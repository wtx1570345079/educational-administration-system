package com.bear.service;

import java.util.List;

import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;

public interface StudentService {
     // 返回当前页的数据   当前页   每一页的显示数量
	 DataGrid  showCurpageStudnet(int Curpage,int pageSize);
	 
	 // 增删改方法需要固定的开头 ins del upd
	 // 修改学生
	 int updateStudent(Student stu);
	 // 删除学生
	 int deleteStudent(int id);
	 
	 // 添加学生
	 int insStudent(Student stu);
	 
	//根据学生的number学号和姓名  查询出学生对象
	 Student selByNumber_Name(String number,String name);
	 
	 // 查看自己的成绩
	 DataGrid selStuScore(int stuid,int curPage,int pageSize);
}
