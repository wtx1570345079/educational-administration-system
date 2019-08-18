package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Course;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;

public interface TeacherMapper {
    
	// ��ѯȫ���Ľ�ʦ����
	int selAll();
	// ��ѯ��ǰҳ������  ��ǰҳ��ÿһҳ�����ݴ�С
	List<Teacher>  selCurpageData(@Param("startPage")int startPage,@Param("pageSize")int pageSize);
	
	// �޸���ʦ������Ϣ
	int updateTeacher(Teacher teacher);
	// �޸Ĺ�����course_teacher����Ϣ  ������ʦ��id
	int  updateCourse_Teacher(@Param("courseid")int courseid,@Param("oldcid")int oldcid);
	
	// ��ӽ�ʦ ������Ϣ
	int addTeacher(Teacher teacher);
	// ��ӹ�����course_teacher����Ϣ
	int addCourse_Teacher(@Param("courseid")int courseid,@Param("teacherid")int teacherid);
	
	// ������ʦ�Ĺ��Ų�������ڵ�id
	int selByTeacherNumber(Teacher teacher);
	
	
	// ɾ����ʦ������Ϣ
	int deleteTeacher(int id);
	// ɾ��������course_teacher����Ϣ  ��ʦidȥɾ��
    int deleteCourse_Teacher(int id);
    
    // ���ݽ�ʦ��id ��ѯ�����Ĺ���
     Teacher selById(int id);
     
     // ��ʦ¼��ɼ�  ��ѯ����ѧ�������гɼ���ѧ��  ��û�ɼ���ѧ��
     // ����������̿γ̵��гɼ���ѧ��  
     // ��ѯ��ǰ�γ�û�гɼ���ѧ��     �б���
     List<Student>  selTeachStudentScore(@Param("teacherid")int teacherid,@Param("startPage")int startPage,@Param("pageSize")int pageSize);
     
     // ͨ��number �� name ��ѯ��ʦ
     Teacher   selNumber_Name(@Param("number")String number,@Param("name") String name);
     
     
     // ¼��ɼ�
     int  addStudnetScore(Score score);
     
     // ���ݽ�ʦid ��ѯ��courseid
     int selCourseId(int teacherid);
}
