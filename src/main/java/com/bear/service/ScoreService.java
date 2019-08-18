package com.bear.service;

import com.bear.pojo.DataGrid;

public interface ScoreService {
	
	// 查询当前页分数
	 DataGrid  selCurPageScore(int curPage,int pageSize,String coursename);
	 
	 // 修改分数
	 int updateScore(int id,String score);
      //删除成绩
	 int delScore(int id);
}
