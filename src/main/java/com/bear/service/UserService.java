package com.bear.service;

import com.bear.pojo.Student;
import com.bear.pojo.User;

public interface UserService {
	
	User login(User user);
	// 增删改方法需要固定的开头  ins del upd
	
	// 查询出学生用户
	 User selByUserId(int id);
}
