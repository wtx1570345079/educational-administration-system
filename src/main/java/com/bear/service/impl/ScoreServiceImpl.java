package com.bear.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.ScoreMapper;
import com.bear.pojo.DataGrid;
import com.bear.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Resource
	private ScoreMapper scoreMapper;
     
	//≤È—Øµ±«∞“≥
	@Override
	public DataGrid selCurPageScore(int curPage, int pageSize,String coursename) {
		// TODO Auto-generated method stub
		DataGrid datagrid=new DataGrid();
		datagrid.setRows(scoreMapper.selCurPageScore((curPage-1)*pageSize,pageSize,coursename));
		datagrid.setTotal(scoreMapper.selAll());
		return  datagrid;
	}

	@Override
	public int updateScore(int id, String score) {
		// TODO Auto-generated method stub
		int index = scoreMapper.updateScore(id, score);
		return index;
	}

	@Override
	public int delScore(int id) {
		// TODO Auto-generated method stub
		return scoreMapper.deleteScore(id);
	}

}
