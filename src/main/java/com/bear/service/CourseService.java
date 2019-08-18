package com.bear.service;

import java.util.List;

import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;

public interface CourseService {
	
	// 查询已选择的课程
	List<Course> selAsignedCourse();
    
	
	//查询当前页的课程
	DataGrid selCurpageCourse(int curPage,int pageSize);
	
	// 添加课程
	int insCourse(Course course);
	
	//查询全部的课程
	List<Course>   selAllCourse();
	
	// 根据id  查询出课程
	Course selById(int id);
	
	
}
