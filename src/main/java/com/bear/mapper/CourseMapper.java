package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Course;

public interface CourseMapper {
    // 查询老师已经选择的课程    一个老师可以教多门课  一门课只能有一门老师   根据courseid 查询老师
	List<Course> selAsignedCourse();
	
	//查询总记录数
	int selAll();
	// 查询总共的课程
	List<Course> selAllCourse();
	// 查询当前页课程
	List<Course> selCurpageCourse(@Param("startPage")int startPage,@Param("pageSize")int pageSize);
	
	//根据id去查成绩
	Course selCourseById(int id);
	
	// 添加课程
	 int  addCourse(Course course);
	 
}
