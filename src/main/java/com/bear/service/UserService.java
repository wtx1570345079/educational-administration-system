package com.bear.service;

import com.bear.pojo.Student;
import com.bear.pojo.User;

public interface UserService {
	
	User login(User user);
	// ��ɾ�ķ�����Ҫ�̶��Ŀ�ͷ  ins del upd
	
	// ��ѯ��ѧ���û�
	 User selByUserId(int id);
}
