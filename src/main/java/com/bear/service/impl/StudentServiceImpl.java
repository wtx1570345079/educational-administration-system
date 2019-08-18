package com.bear.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.ScoreMapper;
import com.bear.mapper.StudentMapper;
import com.bear.mapper.UserMapper;
import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Student;
import com.bear.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ScoreMapper scoreMapper;
    @Resource
    private  UserMapper userMapper;
	@Override
	public DataGrid showCurpageStudnet(int curPage, int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
	     dataGrid.setTotal(studentMapper.selAll());
	     // ����ǰҳ��-1��*pageSize
	     dataGrid.setRows(studentMapper.showCurpage((curPage-1)*pageSize,pageSize));
		return dataGrid;
	}

	@Override
	public int updateStudent(Student stu) {
		// TODO Auto-generated method stub
		// �޸��û���ѧ��name
		userMapper.updateStudent(stu);
		return studentMapper.updateStudent(stu);
	}

	//ɾ��ѧ��
	@Override
	public int deleteStudent(int id) {
		// TODO Auto-generated method stub
		// ɾ���û����е�ѧ������
		Student student = studentMapper.selById(id);
		userMapper.delStudent(student);
		return studentMapper.deleteStudnet(id);
		
	}

	@Override
	public int insStudent(Student stu) {
		// TODO Auto-generated method stub
		userMapper.addStudent(stu);
		return studentMapper.addStudent(stu);
	}

	// �鿴ѧ���Լ��ĳɼ�
	@Override
	public DataGrid selStuScore(int stuid,int curPage,int pageSize) {
		// TODO Auto-generated method stub
		DataGrid dataGrid=new DataGrid();
		dataGrid.setRows(studentMapper.selStuScore(stuid,(curPage-1)*pageSize, pageSize));
		dataGrid.setTotal(studentMapper.selAll());
		return  dataGrid;
	}
    
	// ����ѧ�ź�������ѯ������ѧ������
	@Override
	public Student selByNumber_Name(String number, String name) {
		// TODO Auto-generated method stub
		return studentMapper.selByNumber_Name(number, name);
	}

}
