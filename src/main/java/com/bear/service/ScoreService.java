package com.bear.service;

import com.bear.pojo.DataGrid;

public interface ScoreService {
	
	// ��ѯ��ǰҳ����
	 DataGrid  selCurPageScore(int curPage,int pageSize,String coursename);
	 
	 // �޸ķ���
	 int updateScore(int id,String score);
      //ɾ���ɼ�
	 int delScore(int id);
}
