package com.webbanhang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.webbanhang.entity.SlideEntity;

@Service
public interface ISlideService{
	public List<SlideEntity> GetDataSlide();
}
