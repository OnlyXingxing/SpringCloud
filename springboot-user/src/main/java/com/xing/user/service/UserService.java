package com.xing.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xing.user.dao.UserMapper;
import com.xing.user.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
		
	@Transactional
	public User findByName(String name) {
		return userMapper.selectByName(name);
	}
	
	@Transactional
	public User findByNameEn(String nameEn) {
		return userMapper.selectByNameEn(nameEn);
	}
}
