package com.bear.controller;

import java.lang.annotation.Repeatable;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bear.mapper.ScoreMapper;
import com.bear.pojo.DataGrid;
import com.bear.service.impl.ScoreServiceImpl;

@Controller
public class ScoreController {
	@Resource
	private ScoreServiceImpl scoreServiceImpl;
	
	
	@RequestMapping("pages/manager/scoreList")
	@ResponseBody
	public DataGrid selCurPage(@RequestParam(defaultValue="1")int page,@RequestParam(defaultValue="10")int rows,@RequestParam("coursename") String coursename){
		System.out.println("coursename"+coursename);
		DataGrid selCurPageScore = scoreServiceImpl.selCurPageScore(page, rows,coursename);
		return selCurPageScore;
	}
	/**
	 * ÐÞ¸Ä³É¼¨
	 * @param id
	 * @param score
	 * @return
	 */
	@RequestMapping("pages/manager/updateScore")
	@ResponseBody
	public int updateScore(int id,String score){
		int index=scoreServiceImpl.updateScore(id, score);
		return index;
	}
	
	/**
	 * É¾³ý³É¼¨
	 */
	@RequestMapping("pages/manager/deleteScore")
	@ResponseBody
	public int deleteScore(int id){
		
		int index= scoreServiceImpl.delScore(id);
		return index;
	}
    
	
}
