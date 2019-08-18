package com.bear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.StudentMapper;
import com.bear.mapper.TeacherMapper;
import com.bear.mapper.UserMapper;
import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;
import com.bear.service.TeacherService;

@Service
public class TeacherSerivceImpl  implements TeacherService {
	
	// easyui分页  返回rows和total
	@Resource
    private  TeacherMapper teacherMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private StudentMapper StudentMapper;
	
	@Override
	public DataGrid teacherList(int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
		List<Teacher> teacher = teacherMapper.selCurpageData((curPage-1)*pageSize, pageSize);
		for (Teacher teacher2 : teacher) {
			if(teacher2.getCourse()==null){
				Course course=new Course();
				course.setName("未安排课程!");
				teacher2.setCourse(course);
			}
		}
		// 当前页-1*每一页的大小
		dataGrid.setRows(teacher);
		dataGrid.setTotal(teacherMapper.selAll());
		return dataGrid;
	}
	// 修改教师的基本信息
	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		// 修改用户表教师name
		userMapper.updateTeacher(teacher);
		return teacherMapper.updateTeacher(teacher);
	}
	// 修改关联表的相关信息
	@Override
	public int updateCourse_Teacher(int courseid, int oldcid) {
		// TODO Auto-generated method stub
		
		return teacherMapper.updateCourse_Teacher(courseid, oldcid);
	}
	// 添加教师的基本信息
	@Override
	public int insTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		// 添加用户 到用户表
		userMapper.addTeacher(teacher);
		
		return teacherMapper.addTeacher(teacher);
	}
	
	// 添加关联表的信息
	@Override
	public int insCourse_Teacher(int courseid,Teacher teacher) {
		// TODO Auto-generated method stub
		// 查询新添加老师的id
		int tid = teacherMapper.selByTeacherNumber(teacher);
		
		
		return teacherMapper.addCourse_Teacher(courseid, tid);
	}
	
	//删除教师基本信息
	@Override
	public int deleteTeacher(int id) {
		// TODO Auto-generated method stub
		// 从用户表删除老师
		Teacher teacher = teacherMapper.selById(id);
		userMapper.delTeacher(teacher);
		return teacherMapper.deleteTeacher(id);
	}
	
	// 删除教师课程关联表  教师id
	@Override
	public int delCourse_Teacher(int id) {
    // TODO Auto-generated method stub
	return teacherMapper.deleteCourse_Teacher(id);
	}
	
	// 查询自身所教课程没有成绩的学生
	@Override
	public DataGrid selTeachStudentScore(int teacherid,int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
		List<Student> stuList= teacherMapper.selTeachStudentScore(teacherid,(curPage-1)*pageSize,pageSize);
		for (Student student : stuList) {
			// 如果score对象为null
			if(student.getScore()==null){
				Score score=new Score();
				score.setScore("成绩未录入！");
				student.setScore(score);
			}
		}
		// 将没有成绩的学生封装到  datagrid的对象属性中
		dataGrid.setRows(stuList);
		dataGrid.setTotal(StudentMapper.selAll());
		return dataGrid;
	}
	
	// 根据老师  的number 和name  查询老师
	@Override
	public Teacher selNumber_Name(String number, String name) {
		// TODO Auto-generated method stub
		return  teacherMapper.selNumber_Name(number, name);
	}
	
	// 添加学生分数
	@Override
	public int insStudentScore(Score score) {
		// TODO Auto-generated method stub
		return teacherMapper.addStudnetScore(score);
	}
	
	@Override
	public int selCourseId(int teacherid) {
		// TODO Auto-generated method stub
		return teacherMapper.selCourseId(teacherid);
	}

}
