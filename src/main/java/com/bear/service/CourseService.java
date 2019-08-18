package com.bear.service;

import java.util.List;

import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;

public interface CourseService {
	
	// ��ѯ��ѡ��Ŀγ�
	List<Course> selAsignedCourse();
    
	
	//��ѯ��ǰҳ�Ŀγ�
	DataGrid selCurpageCourse(int curPage,int pageSize);
	
	// ��ӿγ�
	int insCourse(Course course);
	
	//��ѯȫ���Ŀγ�
	List<Course>   selAllCourse();
	
	// ����id  ��ѯ���γ�
	Course selById(int id);
	
	
}
