package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.entity.MenuEntity;
import com.webbanhang.repository.MenuRepository;
import com.webbanhang.service.IMenuService;

@Service
public class MenuService implements IMenuService{

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public List<MenuEntity> GetDataMenu() {
		List<MenuEntity> menu = new ArrayList<MenuEntity>();
		menu = menuRepository.findAll();
		return menu;
	}

}
