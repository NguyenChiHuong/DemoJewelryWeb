package com.webbanhang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.converter.UserConverter;
import com.webbanhang.dto.UserInfo;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.UserRepository;
import com.webbanhang.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserEntity save(UserInfo dto) {
		dto.addRole("USER");
        UserEntity user = userConverter.toEntity(dto);
        return userRepository.save(user);
	}
	
}
