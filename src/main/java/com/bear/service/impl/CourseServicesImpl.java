package com.bear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.CourseMapper;
import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.service.CourseService;

@Service
public class CourseServicesImpl implements CourseService{
    @Resource
	private CourseMapper courseMapper;
     
	@Override
	public List<Course> selAsignedCourse() {
		// TODO Auto-generated method stub
		return courseMapper.selAsignedCourse();
	}
	
    /**
     * 
     * ��ѯ�����пγ�
     */
	@Override
	public DataGrid selCurpageCourse(int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid datagrid=new DataGrid();
		// ��ʼ����  ÿһҳ����
		datagrid.setRows(courseMapper.selCurpageCourse((curPage-1)*pageSize, pageSize));
		datagrid.setTotal(courseMapper.selAll());
		return datagrid;
	}
    // ��ӿγ�
	@Override
	public int insCourse(Course course) {
		return courseMapper.addCourse(course);
	}
    // ��ѯȫ���Ŀγ��б�
	@Override
	public List<Course> selAllCourse() {
		// TODO Auto-generated method stub
		return courseMapper.selAllCourse();
	}
    
	// ����id  ȥ��ѯ�γ�
	@Override
	public Course selById(int id) {
		// TODO Auto-generated method stub
		return courseMapper.selCourseById(id);
	}
    
}
