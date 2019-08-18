package com.bear.controller;

import java.lang.annotation.Repeatable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Teacher;
import com.bear.pojo.User;
import com.bear.service.impl.TeacherSerivceImpl;
import com.bear.service.impl.UserServiceImpl;

@Controller
public class TeacherController {
    
	@Resource
	private TeacherSerivceImpl teacherSerivceImpl;
	
	// 返回datagrid 包含 rows 和 total  默认走第一页
	@RequestMapping("pages/manager/teacherList")
	@ResponseBody
	public DataGrid  curPage(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows){
		DataGrid datagrid = teacherSerivceImpl.teacherList(page, rows);
		return datagrid;
	}
	
	/**
	 * 修改教师
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/updateTeacher")
	@ResponseBody
	public int updateTeacher(Teacher teacher,@RequestParam("courseid") int courseid,@RequestParam("oldcid") int oldcid){
		System.out.println(courseid+"---"+oldcid);
		Course course =new Course();
		course.setId(courseid);
		teacher.setCourse(course);
		// 表示未安排课程的老师   只修改基本信息
		if(oldcid==0&&courseid==0){
			// 更新老师的基本信息
			int index = teacherSerivceImpl.updateTeacher(teacher);
			return index;
		}else if(oldcid==0&&courseid!=0){
			// 给未安排课程的老师安排课程   添加课程与老师的关系
			int index=teacherSerivceImpl.insCourse_Teacher(courseid, teacher);
			System.out.println("未安排课程的老师"+index);
			return index;
		}else if(oldcid!=0){
		// 给已经安排课程的老师修改信息
		int index = teacherSerivceImpl.updateTeacher(teacher);
		// 更新关联表 course_teacher
		index+=teacherSerivceImpl.updateCourse_Teacher(courseid, oldcid);
		System.out.println("修改安排过课程老师的index:"+index);
		return  index;
		}else{
			return 0;
		}
	}
	
	/**
	 * 添加教师   没有课程的教师   有课程的教师
	 * 基本信息和关联表的信息
	 *  关联表的信息 包括couseid 和 teacherid   
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/addTeacher")
	@ResponseBody
	public int addTeacher(Teacher teacher,@RequestParam("courseid") int courseid){
		System.out.println("安排的课程:"+courseid);
		// 判断只添加教师信息  不添加课程
		if(courseid==0){
			//添加教师的基本信息
			int index = teacherSerivceImpl.insTeacher(teacher);
			return index;
		}else{
			//两个都添加
			//添加教师的基本信息
			int index = teacherSerivceImpl.insTeacher(teacher);
			//在添加关联表信息   courseid   根据新添加老师的id写入teacherid
			index+=teacherSerivceImpl.insCourse_Teacher(courseid,teacher);
			System.out.println("添加教师的index:"+index);
			return index;
		}
	}
	
	/**
	 * 删除教师
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/deleteTeacher")
	@ResponseBody
	public int deleteTeacher(int id){
		// 删除基本信息表
		int index = teacherSerivceImpl.deleteTeacher(id);
		// 删除关联表
		index+=teacherSerivceImpl.delCourse_Teacher(id);
		return index;
	}
	/**
	 * 查询自身所教课程的没有成绩的学生
	 * @return
	 */
	@RequestMapping("pages/teacher/stuscoreList")
	@ResponseBody
	public DataGrid selTeachStudentScore(HttpServletRequest request,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10")int rows){
		User user = (User) request.getSession().getAttribute("user");
		// 根据教师用户的number  和 name  查询教师
		Teacher teacher = teacherSerivceImpl.selNumber_Name(user.getUsername(), user.getName());
		DataGrid dataGrid = teacherSerivceImpl.selTeachStudentScore(teacher.getId(),page,rows);
		return dataGrid;
	}
	/**
	 * 添加学生的课程成绩
	 * @return
	 */
	@RequestMapping("pages/teacher/addStudnetCourseScore")
	@ResponseBody
	public int addStudentScore(HttpServletRequest request,@RequestParam("stuid") int stuid,@RequestParam("score") String score){
		
		// 根据教师用户的username 和name 查询教师的id
		User user = (User) request.getSession().getAttribute("user");
		Teacher teacher = teacherSerivceImpl.selNumber_Name(user.getUsername(), user.getName());
		System.out.println(teacher.getId());
		// 根据teacher id获取到 course_teacher   courseid
		int courseid = teacherSerivceImpl.selCourseId(teacher.getId());
		Score score2=new Score();
		score2.setStudentid(stuid);
		score2.setScore(score);
		score2.setCourseid(courseid);
		int index = teacherSerivceImpl.insStudentScore(score2);
		return index;
	}
	
}
