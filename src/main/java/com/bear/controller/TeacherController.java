package com.bear.controller;

import java.lang.annotation.Repeatable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.Course;
import com.bear.pojo.DataGrid;
import com.bear.pojo.Score;
import com.bear.pojo.Teacher;
import com.bear.pojo.User;
import com.bear.service.impl.TeacherSerivceImpl;
import com.bear.service.impl.UserServiceImpl;

@Controller
public class TeacherController {
    
	@Resource
	private TeacherSerivceImpl teacherSerivceImpl;
	
	// ����datagrid ���� rows �� total  Ĭ���ߵ�һҳ
	@RequestMapping("pages/manager/teacherList")
	@ResponseBody
	public DataGrid  curPage(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows){
		DataGrid datagrid = teacherSerivceImpl.teacherList(page, rows);
		return datagrid;
	}
	
	/**
	 * �޸Ľ�ʦ
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/updateTeacher")
	@ResponseBody
	public int updateTeacher(Teacher teacher,@RequestParam("courseid") int courseid,@RequestParam("oldcid") int oldcid){
		System.out.println(courseid+"---"+oldcid);
		Course course =new Course();
		course.setId(courseid);
		teacher.setCourse(course);
		// ��ʾδ���ſγ̵���ʦ   ֻ�޸Ļ�����Ϣ
		if(oldcid==0&&courseid==0){
			// ������ʦ�Ļ�����Ϣ
			int index = teacherSerivceImpl.updateTeacher(teacher);
			return index;
		}else if(oldcid==0&&courseid!=0){
			// ��δ���ſγ̵���ʦ���ſγ�   ��ӿγ�����ʦ�Ĺ�ϵ
			int index=teacherSerivceImpl.insCourse_Teacher(courseid, teacher);
			System.out.println("δ���ſγ̵���ʦ"+index);
			return index;
		}else if(oldcid!=0){
		// ���Ѿ����ſγ̵���ʦ�޸���Ϣ
		int index = teacherSerivceImpl.updateTeacher(teacher);
		// ���¹����� course_teacher
		index+=teacherSerivceImpl.updateCourse_Teacher(courseid, oldcid);
		System.out.println("�޸İ��Ź��γ���ʦ��index:"+index);
		return  index;
		}else{
			return 0;
		}
	}
	
	/**
	 * ��ӽ�ʦ   û�пγ̵Ľ�ʦ   �пγ̵Ľ�ʦ
	 * ������Ϣ�͹��������Ϣ
	 *  ���������Ϣ ����couseid �� teacherid   
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/addTeacher")
	@ResponseBody
	public int addTeacher(Teacher teacher,@RequestParam("courseid") int courseid){
		System.out.println("���ŵĿγ�:"+courseid);
		// �ж�ֻ��ӽ�ʦ��Ϣ  ����ӿγ�
		if(courseid==0){
			//��ӽ�ʦ�Ļ�����Ϣ
			int index = teacherSerivceImpl.insTeacher(teacher);
			return index;
		}else{
			//���������
			//��ӽ�ʦ�Ļ�����Ϣ
			int index = teacherSerivceImpl.insTeacher(teacher);
			//����ӹ�������Ϣ   courseid   �����������ʦ��idд��teacherid
			index+=teacherSerivceImpl.insCourse_Teacher(courseid,teacher);
			System.out.println("��ӽ�ʦ��index:"+index);
			return index;
		}
	}
	
	/**
	 * ɾ����ʦ
	 * @param teacher
	 * @return
	 */
	@RequestMapping("pages/manager/deleteTeacher")
	@ResponseBody
	public int deleteTeacher(int id){
		// ɾ��������Ϣ��
		int index = teacherSerivceImpl.deleteTeacher(id);
		// ɾ��������
		index+=teacherSerivceImpl.delCourse_Teacher(id);
		return index;
	}
	/**
	 * ��ѯ�������̿γ̵�û�гɼ���ѧ��
	 * @return
	 */
	@RequestMapping("pages/teacher/stuscoreList")
	@ResponseBody
	public DataGrid selTeachStudentScore(HttpServletRequest request,@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="10")int rows){
		User user = (User) request.getSession().getAttribute("user");
		// ���ݽ�ʦ�û���number  �� name  ��ѯ��ʦ
		Teacher teacher = teacherSerivceImpl.selNumber_Name(user.getUsername(), user.getName());
		DataGrid dataGrid = teacherSerivceImpl.selTeachStudentScore(teacher.getId(),page,rows);
		return dataGrid;
	}
	/**
	 * ���ѧ���Ŀγ̳ɼ�
	 * @return
	 */
	@RequestMapping("pages/teacher/addStudnetCourseScore")
	@ResponseBody
	public int addStudentScore(HttpServletRequest request,@RequestParam("stuid") int stuid,@RequestParam("score") String score){
		
		// ���ݽ�ʦ�û���username ��name ��ѯ��ʦ��id
		User user = (User) request.getSession().getAttribute("user");
		Teacher teacher = teacherSerivceImpl.selNumber_Name(user.getUsername(), user.getName());
		System.out.println(teacher.getId());
		// ����teacher id��ȡ�� course_teacher   courseid
		int courseid = teacherSerivceImpl.selCourseId(teacher.getId());
		Score score2=new Score();
		score2.setStudentid(stuid);
		score2.setScore(score);
		score2.setCourseid(courseid);
		int index = teacherSerivceImpl.insStudentScore(score2);
		return index;
	}
	
}
