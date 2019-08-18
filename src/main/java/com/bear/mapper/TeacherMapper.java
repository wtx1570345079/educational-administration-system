package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Course;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;

public interface TeacherMapper {
    
	// 查询全部的教师个数
	int selAll();
	// 查询当前页的数据  当前页和每一页的数据大小
	List<Teacher>  selCurpageData(@Param("startPage")int startPage,@Param("pageSize")int pageSize);
	
	// 修改老师基本信息
	int updateTeacher(Teacher teacher);
	// 修改关联表course_teacher的信息  根据老师的id
	int  updateCourse_Teacher(@Param("courseid")int courseid,@Param("oldcid")int oldcid);
	
	// 添加教师 基本信息
	int addTeacher(Teacher teacher);
	// 添加关联表course_teacher的信息
	int addCourse_Teacher(@Param("courseid")int courseid,@Param("teacherid")int teacherid);
	
	// 根据老师的工号查出他所在的id
	int selByTeacherNumber(Teacher teacher);
	
	
	// 删除教师基本信息
	int deleteTeacher(int id);
	// 删除关联表course_teacher的信息  教师id去删除
    int deleteCourse_Teacher(int id);
    
    // 根据教师的id 查询出他的工号
     Teacher selById(int id);
     
     // 老师录入成绩  查询所有学生包含有成绩的学生  和没成绩的学生
     // 查出自身所教课程的有成绩的学生  
     // 查询当前课程没有成绩的学生     列表结合
     List<Student>  selTeachStudentScore(@Param("teacherid")int teacherid,@Param("startPage")int startPage,@Param("pageSize")int pageSize);
     
     // 通过number 和 name 查询老师
     Teacher   selNumber_Name(@Param("number")String number,@Param("name") String name);
     
     
     // 录入成绩
     int  addStudnetScore(Score score);
     
     // 根据教师id 查询出courseid
     int selCourseId(int teacherid);
}
