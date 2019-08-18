package com.bear.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.Course;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;
import com.bear.pojo.User;
import com.bear.service.impl.CourseServicesImpl;
import com.bear.service.impl.StudentServiceImpl;
import com.bear.service.impl.TeacherSerivceImpl;
import com.bear.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Resource
    private UserServiceImpl userServiceImpl;
	
	@Resource
	private StudentServiceImpl studentServiceImpl;
	
	@Resource
	private TeacherSerivceImpl teacherSerivceImpl;
	
	@Resource
	private CourseServicesImpl courseServiceImpl;
	
	
	/**
	 * 拦截器不拦截jsp文件，所以要设置视图解析器将其通过控制器访问页面
	 * restful风格  进入到main.jsp需要进行拦截器验证   {}占位符
	 * @return
	 */
    /* @RequestMapping("{page}")
	 public String main(@PathVariable String page){
		System.out.println("restful");
		return page;
	  }*/
	
	
	/**
	 * 登录   优先匹配login
	 * @param user
	 * @param valid
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	@ResponseBody
	public String login(User user,@RequestParam("validcode") String valid,HttpServletRequest request){
		User user2=userServiceImpl.login(user);
		HttpSession session = request.getSession();
		// 判断user是否存在
		if(user2!=null&&!user2.equals("")){
			// 判断验证码
			String code=(String) request.getSession().getAttribute("code");
			System.out.println(code+"---"+valid);
		      if(code.equals(valid)){
				//0 失败   1 系统管理员   2 学生    3教师
		    	  //判断 用户角色 类型是否匹配  
				if(user2.getType()==user.getType()&&user2.getType()==1){
					session.setAttribute("user", user2);
					return "1";
				}else if(user2.getType()==user.getType()&&user2.getType()==2){
					session.setAttribute("user", user2);
					return "2";
				}else if(user2.getType()==user.getType()&&user2.getType()==3){
					session.setAttribute("user", user2);
					return "3";
				}else{
					// 用户与类型不匹配
					return "03";
				}
			}else{
				// 验证码错误    0 失败
				return "02";}
		}else{
			// 表示用户不存在
			return "01";
		}
		  
	}
	
	@RequestMapping("quit")
	public String quit(HttpServletRequest request){
		// 清除数据
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}
	
	/**
	 * 
	 * 验证码
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	  @RequestMapping(value="validcode")
		public void validcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
//			文字输出流
//			PrintWriter pw=response.getWriter();
//			获取到响应流
//			OutputStream os=response.getOutputStream();
//			InputStream is=new FileInputStream(new File(getServletContext().getRealPath("images"),"a.png"));
//			int index=-1;
//			while((index=is.read())!=-1){
//				os.write(index);
//			}
			
//			画板类Graphics() 
//			创建一张图形  BufferedImage
			BufferedImage image=new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
//			想象最下面铺一层透明玻璃
//			向画板上画内容之前，必须先设置画笔
			Graphics2D gra=image.createGraphics();
//			先设置画笔为白色
			gra.setColor(Color.WHITE);
//			再将画板填充为白色,从哪个坐标开始填充，后面两个表示矩形区域
			gra.fillRect(0, 0, 200,100);
//			现在写验证码数字,画笔颜色设置为黑色，四个数字 范围0~9
			gra.setColor(Color.BLACK);
			gra.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,40));
			List<Integer> list=new ArrayList<>();
			Color[] colors={Color.BLACK,Color.BLUE,Color.RED,Color.CYAN,Color.GREEN,Color.PINK,Color.YELLOW};
			Random random=new Random();
			for(int i=0;i<4;i++){
//				左闭右开
				list.add(random.nextInt(10));
			}
//			随机设置字体颜色，数字大小
			for(int i=0;i<list.size();i++){
				gra.setColor(colors[new Random().nextInt(6)]);
//				0~21之间的数字减10
				gra.drawString(list.get(i)+" ", i*40,70+(new Random().nextInt(21)-10));
			}
			
//			划两条横线   起点坐标，终点坐标
			for(int i=0;i<2;i++){
				gra.setColor(colors[new Random().nextInt(6)]);
				gra.drawLine(0,new Random().nextInt(101), 200,new Random().nextInt(101));
			}
			
			OutputStream os=response.getOutputStream();
//			工具类imageIO  write(RenderedImage im, String formatName, OutputStream output) 
//			使用支持给定格式的任意 ImageWriter写入图像到 OutputStream 。 
			ImageIO.write(image,"jpg",os);
			
//			将验证码存在在session对象中
			request.getSession().setAttribute("code", ""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
		}
	  
	  /**
	   * 查询学生用户信息  根虎  number  name 查询
	   * @return
	   */
	  @RequestMapping("selStuUser")
	  @ResponseBody
	  public  Student selByStuName_Number(@RequestParam("name") String name,@RequestParam("number") String number){
		  Student student = studentServiceImpl.selByNumber_Name(number, name);
		  return student;
	  }
	  
	  
	  
	  /**
	   * 查询教师用户信息  根据number   name 查询
	   * @return
	   */
	  @RequestMapping("selTeaUser")
	  @ResponseBody
	  public  Teacher selByTeaName_Number(@RequestParam("name") String name,@RequestParam("number") String number){
		  
		  Teacher teacher = teacherSerivceImpl.selNumber_Name(number, name);
		  // 根据teacher id 查询出课程id  course_teacher
		  int selCourseId = teacherSerivceImpl.selCourseId(teacher.getId());
		  // 查询教师所教课程
		  Course course = courseServiceImpl.selById(selCourseId);
		  // 判断教师所教课程是否为null
		  if(course==null){
			  teacher.setCourse(new Course());
			 teacher.getCourse().setName("未安排课程");
		  }else{
			  teacher.setCourse(course);
		  }
		  return teacher;
	  }
	  
	  
}
