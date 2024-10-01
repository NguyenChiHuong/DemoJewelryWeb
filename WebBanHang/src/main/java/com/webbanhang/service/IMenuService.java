package com.webbanhang.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webbanhang.entity.MenuEntity;

@Service
public interface IMenuService {
	public List<MenuEntity> GetDataMenu();
}
