package com.webbanhang.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.webbanhang.dto.UserInfo;
import com.webbanhang.entity.RoleEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.repository.RoleRepository;

@Component
public class UserConverter {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public UserEntity toEntity(UserInfo user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(user.getUsername());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
		userEntity.setFullName(user.getFullName());
		userEntity.setEmail(user.getEmail());
		userEntity.setStatus(1);
		userEntity.setRoles(convertToRoleEntities(user.getRoles()));
		return userEntity;
	}
	
	private List<RoleEntity> convertToRoleEntities(List<String> roles) {
        List<RoleEntity> roleEntities = new ArrayList<>();
        for (String code : roles) {
            RoleEntity roleEntity = roleRepository.findByCode(code);
            if (roleEntity != null) {
                roleEntities.add(roleEntity);
            }
        }
        return roleEntities;
    }
}
