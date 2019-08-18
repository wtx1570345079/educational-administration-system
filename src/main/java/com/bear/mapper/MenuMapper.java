package com.bear.mapper;

import java.util.List;

import com.bear.pojo.Attributes;
import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;

public interface MenuMapper {
     //查询所有父菜单
	List<Menu>  selAll();
	
	// 管理员的 根据pid查询子菜单
	List<Menu> selByPid(int pid);
	
    // 学生的 根据pid查询子菜单
    List<StuMenu> selStuByPid(int pid);
    
    // 教师的 根据pid查询子菜单
    List<TeaMenu> selTeaByPid(int pid);
    
	// 教师菜单
	List<TeaMenu> selAlltea();
	
	// 学生菜单
	List<StuMenu> selAllstu();
}
