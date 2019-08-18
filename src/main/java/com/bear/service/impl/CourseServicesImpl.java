package com.bear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.CourseMapper;
import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.service.CourseService;

@Service
public class CourseServicesImpl implements CourseService{
    @Resource
	private CourseMapper courseMapper;
     
	@Override
	public List<Course> selAsignedCourse() {
		// TODO Auto-generated method stub
		return courseMapper.selAsignedCourse();
	}
	
    /**
     * 
     * 查询出所有课程
     */
	@Override
	public DataGrid selCurpageCourse(int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid datagrid=new DataGrid();
		// 起始数据  每一页数据
		datagrid.setRows(courseMapper.selCurpageCourse((curPage-1)*pageSize, pageSize));
		datagrid.setTotal(courseMapper.selAll());
		return datagrid;
	}
    // 添加课程
	@Override
	public int insCourse(Course course) {
		return courseMapper.addCourse(course);
	}
    // 查询全部的课程列表
	@Override
	public List<Course> selAllCourse() {
		// TODO Auto-generated method stub
		return courseMapper.selAllCourse();
	}
    
	// 根据id  去查询课程
	@Override
	public Course selById(int id) {
		// TODO Auto-generated method stub
		return courseMapper.selCourseById(id);
	}
    
}
