package com.bear.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;

public interface TeacherService {
	
	// ��ѯ��ǰҳ������
	DataGrid teacherList(int curPage,int pageSize);
	
	// �޸Ľ�ʦ
	int updateTeacher(Teacher teacher);
	// ���¹��������Ϣ
	int updateCourse_Teacher(int courseid,int oldcid);
	// ��ӽ�ʦ������Ϣ
	int insTeacher(Teacher teacher);
	// ��ӹ��������Ϣ
	int insCourse_Teacher(int courseid,Teacher teacher);
	// ɾ����ʦ
	int deleteTeacher(int id);
	// ɾ����ʦ_�γ̹�����  
	int delCourse_Teacher(int id);
	
	// ��ѯ�������̿γ̵�û�гɼ���ѧ��
	 DataGrid  selTeachStudentScore(int teacherid,int curPage,int pageSize);
     
	 // ����user��number  ��name��ѯ��ʦ
	 Teacher selNumber_Name(String number,String name);
	 
	 // ����ɼ�
	 int  insStudentScore(Score score);
	 
	 // ���ݽ�ʦid  ��ѯ���γ�id
	  int selCourseId(int teacherid);
}
