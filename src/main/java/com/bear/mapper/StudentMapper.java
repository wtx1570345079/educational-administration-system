package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Score;
import com.bear.pojo.Student;

public interface StudentMapper {
     //查询所有学生个数
	 int selAll();
	 //查询每一页要显示的数据
	 List<Student> showCurpage(int startPage,int pageSize);
	 
	 // 修改学生的信息
	 int updateStudent(Student stu);
	 
	 // 删除学生信息
	 int deleteStudnet(int id);
	 
	 // 添加学生
	 int addStudent(Student stu);
	 
	// 根据学生id 查出来学生对象的属性  学号
	  Student selById(int id);
	 
	 //根据学生的number学号和姓名  查询出学生对象
	  Student selByNumber_Name(@Param("number")String number,@Param("name")String name);
	  
	 //学生查看自己的成绩
	 List<Score>  selStuScore(@Param("stuid")int stuid,@Param("startPage")int startPage,@Param("pageSize")int pageSize);
 	 
}
