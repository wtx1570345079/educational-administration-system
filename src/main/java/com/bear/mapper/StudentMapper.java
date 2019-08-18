package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Score;
import com.bear.pojo.Student;

public interface StudentMapper {
     //��ѯ����ѧ������
	 int selAll();
	 //��ѯÿһҳҪ��ʾ������
	 List<Student> showCurpage(int startPage,int pageSize);
	 
	 // �޸�ѧ������Ϣ
	 int updateStudent(Student stu);
	 
	 // ɾ��ѧ����Ϣ
	 int deleteStudnet(int id);
	 
	 // ���ѧ��
	 int addStudent(Student stu);
	 
	// ����ѧ��id �����ѧ�����������  ѧ��
	  Student selById(int id);
	 
	 //����ѧ����numberѧ�ź�����  ��ѯ��ѧ������
	  Student selByNumber_Name(@Param("number")String number,@Param("name")String name);
	  
	 //ѧ���鿴�Լ��ĳɼ�
	 List<Score>  selStuScore(@Param("stuid")int stuid,@Param("startPage")int startPage,@Param("pageSize")int pageSize);
 	 
}
