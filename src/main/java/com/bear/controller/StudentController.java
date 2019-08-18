package com.bear.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.DataGrid;
import com.bear.pojo.Student;
import com.bear.pojo.User;
import com.bear.service.impl.StudentServiceImpl;
import com.bear.service.impl.UserServiceImpl;

@Controller
public class StudentController {
	@Resource
    private StudentServiceImpl studentServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	
	// pages和StudentController同级   页面传递过来的参数为page 和 rows
	@RequestMapping("pages/manager/studentList")
	@ResponseBody
	public DataGrid showStudentList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10")int rows){
	//  dataGrid包含  总记录数  和每一页的数据
	DataGrid dataGrid = studentServiceImpl.showCurpageStudnet(page, rows);
	return dataGrid;
	}
	
	/**
	 * 修改学生
	 * @param stu
	 * @return
	 */
	@RequestMapping("pages/manager/updateStudent")
	@ResponseBody
	public int updateStudent(Student stu){
		System.out.println(stu.toString());
		int index=studentServiceImpl.updateStudent(stu);
		return index;
	}
	
	/**
	 * 删除学生
	 */
	@RequestMapping("pages/manager/deleteStudent")
	@ResponseBody
	public int deleteStudent(int id){
		System.out.println(id);
		int index=studentServiceImpl.deleteStudent(id);
		System.out.println(index);
		return index;
	}
	
	/**
	 * 添加学生
	 * @param stu
	 * @return
	 */
	@RequestMapping("pages/manager/addStudent")
	@ResponseBody
	public int addStudent(Student stu){
		int index = studentServiceImpl.insStudent(stu);
		return index;
	}
	/**
	 * 学生查看自己成绩
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("pages/student/stuscoreList")
	@ResponseBody
	public DataGrid stuscoreList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10") int rows,HttpServletRequest request){
		// user中的学生的id
//		int id=Integer.parseInt(request.getParameter("id"));
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(user.getName()+"---"+user.getUsername());
		// 根据user 的账号和姓名查询出学生
		Student stu = studentServiceImpl.selByNumber_Name(user.getUsername(),user.getName());
		System.out.println("学生id:"+stu.getId());
		DataGrid selStuScore = studentServiceImpl.selStuScore(stu.getId(), page,rows);
		return selStuScore;
	}
	
}
