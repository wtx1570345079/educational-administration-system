package com.bear.mapper;

import com.bear.pojo.Student;
import com.bear.pojo.Teacher;
import com.bear.pojo.User;

public interface UserMapper {
      
	/**
	 * ��ѯ�û��Ƿ����
	 * @param user
	 * @return
	 */
	User selByName_Pwd(User user);
	
	// ���ѧ���û�
	int addStudent(Student stu);
	// ɾ��ѧ���û�
	int delStudent(Student stu);
	// �޸�ѧ���û�
	int updateStudent(Student stu);
	// ��ӽ�ʦ�û�
	int addTeacher(Teacher tea);
	// ɾ����ʦ�û�
	int delTeacher(Teacher tea);
	// �޸Ľ�ʦ�û�
	int updateTeacher(Teacher tea);
	
	// ��ѯ���û�
	User selByUserId(int id);
}
