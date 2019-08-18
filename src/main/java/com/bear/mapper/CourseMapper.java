package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bear.pojo.Course;

public interface CourseMapper {
    // ��ѯ��ʦ�Ѿ�ѡ��Ŀγ�    һ����ʦ���Խ̶��ſ�  һ�ſ�ֻ����һ����ʦ   ����courseid ��ѯ��ʦ
	List<Course> selAsignedCourse();
	
	//��ѯ�ܼ�¼��
	int selAll();
	// ��ѯ�ܹ��Ŀγ�
	List<Course> selAllCourse();
	// ��ѯ��ǰҳ�γ�
	List<Course> selCurpageCourse(@Param("startPage")int startPage,@Param("pageSize")int pageSize);
	
	//����idȥ��ɼ�
	Course selCourseById(int id);
	
	// ��ӿγ�
	 int  addCourse(Course course);
	 
}
