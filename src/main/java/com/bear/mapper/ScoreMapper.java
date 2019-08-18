package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bear.pojo.Score;

@Repository
public interface ScoreMapper {
	
     // 查询当前页的分数
	List<Score> selCurPageScore(@Param("startPage") int startPage,@Param("pageSize") int pageSize,@Param("coursename") String coursename);
	
	//查询全部分数
	int selAll();
	
	//修改分数
	int updateScore(@Param("id")int id,@Param("score")String score);
	
	//删除成绩
	int deleteScore(int id);
	
	// 查询分数
	Score selBySid_Cid(@Param("studentid")int studentid,@Param("courseid")int courseid);
	
	
}
