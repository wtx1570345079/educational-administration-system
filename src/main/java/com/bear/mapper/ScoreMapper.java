package com.bear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.bear.pojo.Score;

@Repository
public interface ScoreMapper {
	
     // ��ѯ��ǰҳ�ķ���
	List<Score> selCurPageScore(@Param("startPage") int startPage,@Param("pageSize") int pageSize,@Param("coursename") String coursename);
	
	//��ѯȫ������
	int selAll();
	
	//�޸ķ���
	int updateScore(@Param("id")int id,@Param("score")String score);
	
	//ɾ���ɼ�
	int deleteScore(int id);
	
	// ��ѯ����
	Score selBySid_Cid(@Param("studentid")int studentid,@Param("courseid")int courseid);
	
	
}
