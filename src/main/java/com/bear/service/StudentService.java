package com.bear.service;

import java.util.List;

import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;

public interface StudentService {
     // ���ص�ǰҳ������   ��ǰҳ   ÿһҳ����ʾ����
	 DataGrid  showCurpageStudnet(int Curpage,int pageSize);
	 
	 // ��ɾ�ķ�����Ҫ�̶��Ŀ�ͷ ins del upd
	 // �޸�ѧ��
	 int updateStudent(Student stu);
	 // ɾ��ѧ��
	 int deleteStudent(int id);
	 
	 // ���ѧ��
	 int insStudent(Student stu);
	 
	//����ѧ����numberѧ�ź�����  ��ѯ��ѧ������
	 Student selByNumber_Name(String number,String name);
	 
	 // �鿴�Լ��ĳɼ�
	 DataGrid selStuScore(int stuid,int curPage,int pageSize);
}
