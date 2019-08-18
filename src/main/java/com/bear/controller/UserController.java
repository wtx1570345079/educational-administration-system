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
	 * ������������jsp�ļ�������Ҫ������ͼ����������ͨ������������ҳ��
	 * restful���  ���뵽main.jsp��Ҫ������������֤   {}ռλ��
	 * @return
	 */
    /* @RequestMapping("{page}")
	 public String main(@PathVariable String page){
		System.out.println("restful");
		return page;
	  }*/
	
	
	/**
	 * ��¼   ����ƥ��login
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
		// �ж�user�Ƿ����
		if(user2!=null&&!user2.equals("")){
			// �ж���֤��
			String code=(String) request.getSession().getAttribute("code");
			System.out.println(code+"---"+valid);
		      if(code.equals(valid)){
				//0 ʧ��   1 ϵͳ����Ա   2 ѧ��    3��ʦ
		    	  //�ж� �û���ɫ �����Ƿ�ƥ��  
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
					// �û������Ͳ�ƥ��
					return "03";
				}
			}else{
				// ��֤�����    0 ʧ��
				return "02";}
		}else{
			// ��ʾ�û�������
			return "01";
		}
		  
	}
	
	@RequestMapping("quit")
	public String quit(HttpServletRequest request){
		// �������
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}
	
	/**
	 * 
	 * ��֤��
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	  @RequestMapping(value="validcode")
		public void validcode(HttpServletRequest request,HttpServletResponse response) throws IOException{
//			���������
//			PrintWriter pw=response.getWriter();
//			��ȡ����Ӧ��
//			OutputStream os=response.getOutputStream();
//			InputStream is=new FileInputStream(new File(getServletContext().getRealPath("images"),"a.png"));
//			int index=-1;
//			while((index=is.read())!=-1){
//				os.write(index);
//			}
			
//			������Graphics() 
//			����һ��ͼ��  BufferedImage
			BufferedImage image=new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);
//			������������һ��͸������
//			�򻭰��ϻ�����֮ǰ�����������û���
			Graphics2D gra=image.createGraphics();
//			�����û���Ϊ��ɫ
			gra.setColor(Color.WHITE);
//			�ٽ��������Ϊ��ɫ,���ĸ����꿪ʼ��䣬����������ʾ��������
			gra.fillRect(0, 0, 200,100);
//			����д��֤������,������ɫ����Ϊ��ɫ���ĸ����� ��Χ0~9
			gra.setColor(Color.BLACK);
			gra.setFont(new Font("����",Font.BOLD|Font.ITALIC,40));
			List<Integer> list=new ArrayList<>();
			Color[] colors={Color.BLACK,Color.BLUE,Color.RED,Color.CYAN,Color.GREEN,Color.PINK,Color.YELLOW};
			Random random=new Random();
			for(int i=0;i<4;i++){
//				����ҿ�
				list.add(random.nextInt(10));
			}
//			�������������ɫ�����ִ�С
			for(int i=0;i<list.size();i++){
				gra.setColor(colors[new Random().nextInt(6)]);
//				0~21֮������ּ�10
				gra.drawString(list.get(i)+" ", i*40,70+(new Random().nextInt(21)-10));
			}
			
//			����������   ������꣬�յ�����
			for(int i=0;i<2;i++){
				gra.setColor(colors[new Random().nextInt(6)]);
				gra.drawLine(0,new Random().nextInt(101), 200,new Random().nextInt(101));
			}
			
			OutputStream os=response.getOutputStream();
//			������imageIO  write(RenderedImage im, String formatName, OutputStream output) 
//			ʹ��֧�ָ�����ʽ������ ImageWriterд��ͼ�� OutputStream �� 
			ImageIO.write(image,"jpg",os);
			
//			����֤�������session������
			request.getSession().setAttribute("code", ""+list.get(0)+list.get(1)+list.get(2)+list.get(3));
		}
	  
	  /**
	   * ��ѯѧ���û���Ϣ  ����  number  name ��ѯ
	   * @return
	   */
	  @RequestMapping("selStuUser")
	  @ResponseBody
	  public  Student selByStuName_Number(@RequestParam("name") String name,@RequestParam("number") String number){
		  Student student = studentServiceImpl.selByNumber_Name(number, name);
		  return student;
	  }
	  
	  
	  
	  /**
	   * ��ѯ��ʦ�û���Ϣ  ����number   name ��ѯ
	   * @return
	   */
	  @RequestMapping("selTeaUser")
	  @ResponseBody
	  public  Teacher selByTeaName_Number(@RequestParam("name") String name,@RequestParam("number") String number){
		  
		  Teacher teacher = teacherSerivceImpl.selNumber_Name(number, name);
		  // ����teacher id ��ѯ���γ�id  course_teacher
		  int selCourseId = teacherSerivceImpl.selCourseId(teacher.getId());
		  // ��ѯ��ʦ���̿γ�
		  Course course = courseServiceImpl.selById(selCourseId);
		  // �жϽ�ʦ���̿γ��Ƿ�Ϊnull
		  if(course==null){
			  teacher.setCourse(new Course());
			 teacher.getCourse().setName("δ���ſγ�");
		  }else{
			  teacher.setCourse(course);
		  }
		  return teacher;
	  }
	  
	  
}
