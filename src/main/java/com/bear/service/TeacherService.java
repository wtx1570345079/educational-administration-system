package com.bear.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;

public interface TeacherService {
	
	// 查询当前页的数据
	DataGrid teacherList(int curPage,int pageSize);
	
	// 修改教师
	int updateTeacher(Teacher teacher);
	// 更新关联表的信息
	int updateCourse_Teacher(int courseid,int oldcid);
	// 添加教师基本信息
	int insTeacher(Teacher teacher);
	// 添加关联表的信息
	int insCourse_Teacher(int courseid,Teacher teacher);
	// 删除教师
	int deleteTeacher(int id);
	// 删除教师_课程关联表  
	int delCourse_Teacher(int id);
	
	// 查询自身所教课程的没有成绩的学生
	 DataGrid  selTeachStudentScore(int teacherid,int curPage,int pageSize);
     
	 // 根据user的number  和name查询老师
	 Teacher selNumber_Name(String number,String name);
	 
	 // 插入成绩
	 int  insStudentScore(Score score);
	 
	 // 根据教师id  查询出课程id
	  int selCourseId(int teacherid);
}
