package com.webbanhang.service;

import org.springframework.stereotype.Service;

import com.webbanhang.dto.UserInfo;
import com.webbanhang.entity.UserEntity;

@Service
public interface IUserService {
	public UserEntity save(UserInfo dto);
	//public UserEntity registerUser(String login,String password,String email,String fullname);
}
