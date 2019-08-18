package com.bear.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bear.mapper.UserMapper;
import com.bear.pojo.Student;
import com.bear.pojo.User;
import com.bear.service.UserService;

@Service
public class UserServiceImpl implements UserService{
     
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.selByName_Pwd(user);   
	}
    
	/**
	 * 根据id查询出用户
	 */
	@Override
	public User selByUserId(int id) {
		// TODO Auto-generated method stub
		return userMapper.selByUserId(id);
	}
  
}
