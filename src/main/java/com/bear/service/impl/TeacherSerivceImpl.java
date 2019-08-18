package com.bear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.StudentMapper;
import com.bear.mapper.TeacherMapper;
import com.bear.mapper.UserMapper;
import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.pojo.Teacher;
import com.bear.service.TeacherService;

@Service
public class TeacherSerivceImpl  implements TeacherService {
	
	// easyui��ҳ  ����rows��total
	@Resource
    private  TeacherMapper teacherMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private StudentMapper StudentMapper;
	
	@Override
	public DataGrid teacherList(int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
		List<Teacher> teacher = teacherMapper.selCurpageData((curPage-1)*pageSize, pageSize);
		for (Teacher teacher2 : teacher) {
			if(teacher2.getCourse()==null){
				Course course=new Course();
				course.setName("δ���ſγ�!");
				teacher2.setCourse(course);
			}
		}
		// ��ǰҳ-1*ÿһҳ�Ĵ�С
		dataGrid.setRows(teacher);
		dataGrid.setTotal(teacherMapper.selAll());
		return dataGrid;
	}
	// �޸Ľ�ʦ�Ļ�����Ϣ
	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		// �޸��û����ʦname
		userMapper.updateTeacher(teacher);
		return teacherMapper.updateTeacher(teacher);
	}
	// �޸Ĺ�����������Ϣ
	@Override
	public int updateCourse_Teacher(int courseid, int oldcid) {
		// TODO Auto-generated method stub
		
		return teacherMapper.updateCourse_Teacher(courseid, oldcid);
	}
	// ��ӽ�ʦ�Ļ�����Ϣ
	@Override
	public int insTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		// ����û� ���û���
		userMapper.addTeacher(teacher);
		
		return teacherMapper.addTeacher(teacher);
	}
	
	// ��ӹ��������Ϣ
	@Override
	public int insCourse_Teacher(int courseid,Teacher teacher) {
		// TODO Auto-generated method stub
		// ��ѯ�������ʦ��id
		int tid = teacherMapper.selByTeacherNumber(teacher);
		
		
		return teacherMapper.addCourse_Teacher(courseid, tid);
	}
	
	//ɾ����ʦ������Ϣ
	@Override
	public int deleteTeacher(int id) {
		// TODO Auto-generated method stub
		// ���û���ɾ����ʦ
		Teacher teacher = teacherMapper.selById(id);
		userMapper.delTeacher(teacher);
		return teacherMapper.deleteTeacher(id);
	}
	
	// ɾ����ʦ�γ̹�����  ��ʦid
	@Override
	public int delCourse_Teacher(int id) {
    // TODO Auto-generated method stub
	return teacherMapper.deleteCourse_Teacher(id);
	}
	
	// ��ѯ�������̿γ�û�гɼ���ѧ��
	@Override
	public DataGrid selTeachStudentScore(int teacherid,int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
		List<Student> stuList= teacherMapper.selTeachStudentScore(teacherid,(curPage-1)*pageSize,pageSize);
		for (Student student : stuList) {
			// ���score����Ϊnull
			if(student.getScore()==null){
				Score score=new Score();
				score.setScore("�ɼ�δ¼�룡");
				student.setScore(score);
			}
		}
		// ��û�гɼ���ѧ����װ��  datagrid�Ķ���������
		dataGrid.setRows(stuList);
		dataGrid.setTotal(StudentMapper.selAll());
		return dataGrid;
	}
	
	// ������ʦ  ��number ��name  ��ѯ��ʦ
	@Override
	public Teacher selNumber_Name(String number, String name) {
		// TODO Auto-generated method stub
		return  teacherMapper.selNumber_Name(number, name);
	}
	
	// ���ѧ������
	@Override
	public int insStudentScore(Score score) {
		// TODO Auto-generated method stub
		return teacherMapper.addStudnetScore(score);
	}
	
	@Override
	public int selCourseId(int teacherid) {
		// TODO Auto-generated method stub
		return teacherMapper.selCourseId(teacherid);
	}

}
