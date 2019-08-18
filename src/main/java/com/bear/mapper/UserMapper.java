package com.bear.mapper;

import com.bear.pojo.Student;
import com.bear.pojo.Teacher;
import com.bear.pojo.User;

public interface UserMapper {
      
	/**
	 * 查询用户是否存在
	 * @param user
	 * @return
	 */
	User selByName_Pwd(User user);
	
	// 添加学生用户
	int addStudent(Student stu);
	// 删除学生用户
	int delStudent(Student stu);
	// 修改学生用户
	int updateStudent(Student stu);
	// 添加教师用户
	int addTeacher(Teacher tea);
	// 删除教师用户
	int delTeacher(Teacher tea);
	// 修改教师用户
	int updateTeacher(Teacher tea);
	
	// 查询出用户
	User selByUserId(int id);
}
