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
	
	// pages��StudentControllerͬ��   ҳ�洫�ݹ����Ĳ���Ϊpage �� rows
	@RequestMapping("pages/manager/studentList")
	@ResponseBody
	public DataGrid showStudentList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10")int rows){
	//  dataGrid����  �ܼ�¼��  ��ÿһҳ������
	DataGrid dataGrid = studentServiceImpl.showCurpageStudnet(page, rows);
	return dataGrid;
	}
	
	/**
	 * �޸�ѧ��
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
	 * ɾ��ѧ��
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
	 * ���ѧ��
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
	 * ѧ���鿴�Լ��ɼ�
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("pages/student/stuscoreList")
	@ResponseBody
	public DataGrid stuscoreList(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10") int rows,HttpServletRequest request){
		// user�е�ѧ����id
//		int id=Integer.parseInt(request.getParameter("id"));
		User user=(User) request.getSession().getAttribute("user");
		System.out.println(user.getName()+"---"+user.getUsername());
		// ����user ���˺ź�������ѯ��ѧ��
		Student stu = studentServiceImpl.selByNumber_Name(user.getUsername(),user.getName());
		System.out.println("ѧ��id:"+stu.getId());
		DataGrid selStuScore = studentServiceImpl.selStuScore(stu.getId(), page,rows);
		return selStuScore;
	}
	
}
