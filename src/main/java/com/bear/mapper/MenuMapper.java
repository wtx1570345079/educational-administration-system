package com.bear.mapper;

import java.util.List;

import com.bear.pojo.Attributes;
import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;

public interface MenuMapper {
     //��ѯ���и��˵�
	List<Menu>  selAll();
	
	// ����Ա�� ����pid��ѯ�Ӳ˵�
	List<Menu> selByPid(int pid);
	
    // ѧ���� ����pid��ѯ�Ӳ˵�
    List<StuMenu> selStuByPid(int pid);
    
    // ��ʦ�� ����pid��ѯ�Ӳ˵�
    List<TeaMenu> selTeaByPid(int pid);
    
	// ��ʦ�˵�
	List<TeaMenu> selAlltea();
	
	// ѧ���˵�
	List<StuMenu> selAllstu();
}
