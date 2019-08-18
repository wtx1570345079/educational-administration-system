package com.bear.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.service.impl.CourseServicesImpl;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class CourseController {
	@Resource
	private CourseServicesImpl courseServicesImpl;
	
	/**
	 * 查询已选择的课程列表
	 * @return
	 */
	@RequestMapping("pages/manager/asignedCourseList")
	@ResponseBody
	public List<Course> selAsignedCourse(){
		List<Course> selAsignedCourse = courseServicesImpl.selAsignedCourse();
	    return selAsignedCourse;
	}
	/**
	 * 查询所有课程
	 * @return
	 */
	@RequestMapping("pages/manager/courseList")
	@ResponseBody
	public DataGrid courselist(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows){
		return courseServicesImpl.selCurpageCourse(page, rows);
	}
	
	/**
	 * 添加课程
	 */
	@RequestMapping("pages/manager/addCourse")
	@ResponseBody
     public int addCourse(Course course){
     int index=courseServicesImpl.insCourse(course);
    return index;
     }
	
	/**
	 * 查询全部课程列表
	 * @return
	 */
	@RequestMapping("pages/manager/selAllCourse")
	@ResponseBody
	public List<Course> selAllCourse(){
		List<Course> selAllCourse = courseServicesImpl.selAllCourse();
		return selAllCourse;
	}
	
	
	
}
