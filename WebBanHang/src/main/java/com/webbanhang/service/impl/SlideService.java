package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webbanhang.entity.SlideEntity;
import com.webbanhang.repository.SlideRepository;
import com.webbanhang.service.ISlideService;

@Service
public class SlideService implements ISlideService{

	@Autowired
	private SlideRepository slideRepository;
	
	@Override
	public List<SlideEntity> GetDataSlide() {
		List<SlideEntity> list = new ArrayList<SlideEntity>();
		list = slideRepository.findAll();
		return list;
	}

}
