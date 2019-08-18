package com.bear.service;

import java.util.List;

import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;

public interface MenuService {
	// 查询全部
     List<Menu> selAll();
  // 增删改方法需要固定的开头   ins del upd
     
     //查询学生菜单
     List<StuMenu>  selAllStuMenu();
     
     // 查询教师菜单
     List<TeaMenu>  selAllTeaMenu();
     
}
