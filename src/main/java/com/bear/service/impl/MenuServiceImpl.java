package com.bear.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.MenuMapper;
import com.bear.pojo.Attributes;
import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;
import com.bear.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService{
    @Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> selAll() {
		// TODO Auto-generated method stub
		System.out.println(menuMapper.selAll());
		List<Menu> list=menuMapper.selAll();
		// 获取到子菜单列表
		List<Menu> chilerenList=list.get(0).getChildren();
		// 遍历子菜单  给属性子菜单中menu的attributes中的filename赋值
		for (Menu menu : chilerenList) {
		 Attributes attr=new Attributes();
		 attr.setFilename(menu.getFilename());
		 menu.setAttributes(attr);
		}
		return menuMapper.selAll();
	}
	@Override
	public List<StuMenu> selAllStuMenu() {
		// TODO Auto-generated method stub
		List<StuMenu> list=menuMapper.selAllstu();
		// 获取到子菜单列表
		List<StuMenu> chilerenList=list.get(0).getChildren();
		// 遍历子菜单  给属性子菜单中menu的attributes中的filename赋值
		for (StuMenu stumenu : chilerenList) {
		 Attributes attr=new Attributes();
		 attr.setFilename(stumenu.getFilename());
		 stumenu.setAttributes(attr);
		}
		return menuMapper.selAllstu();
	}
	@Override
	public List<TeaMenu> selAllTeaMenu() {
		// TODO Auto-generated method stub
				List<TeaMenu> list=menuMapper.selAlltea();
				// 获取到子菜单列表
				List<TeaMenu> chilerenList=(List<TeaMenu>) list.get(0).getChildren();
				// 遍历子菜单  给属性子菜单中menu的attributes中的filename赋值
				for (TeaMenu teamenu : chilerenList) {
				 Attributes attr=new Attributes();
				 attr.setFilename(teamenu.getFilename());
				 teamenu.setAttributes(attr);
				}
				return menuMapper.selAlltea();
	}
	
	
 
}
