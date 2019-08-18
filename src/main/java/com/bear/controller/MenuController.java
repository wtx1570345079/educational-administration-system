package com.bear.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;
import com.bear.service.impl.MenuServiceImpl;

@Controller
public class MenuController {
	
	@Autowired
	private MenuServiceImpl menuServiceImpl;
	
	//����Ա�˵�
	@RequestMapping("pages/manager/showMenu")
	@ResponseBody
	public List<Menu> queryMenu(){
		return menuServiceImpl.selAll();
	}
	
	//��ʦ�˵�
	@RequestMapping("pages/teacher/showTeaMenu")
	@ResponseBody
	public List<TeaMenu> queryMenu2(){
		return menuServiceImpl.selAllTeaMenu();
	}
	
	//ѧ���˵�
		@RequestMapping("pages/student/showStuMenu")
		@ResponseBody
		public List<StuMenu> queryMenu3(){
			return menuServiceImpl.selAllStuMenu();
		}
	
    
}
