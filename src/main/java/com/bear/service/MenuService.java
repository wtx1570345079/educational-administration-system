package com.bear.service;

import java.util.List;

import com.bear.pojo.Menu;
import com.bear.pojo.StuMenu;
import com.bear.pojo.TeaMenu;

public interface MenuService {
	// ��ѯȫ��
     List<Menu> selAll();
  // ��ɾ�ķ�����Ҫ�̶��Ŀ�ͷ   ins del upd
     
     //��ѯѧ���˵�
     List<StuMenu>  selAllStuMenu();
     
     // ��ѯ��ʦ�˵�
     List<TeaMenu>  selAllTeaMenu();
     
}
