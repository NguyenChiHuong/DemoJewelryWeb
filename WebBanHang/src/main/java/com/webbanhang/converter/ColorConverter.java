package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.ColorDTO;
import com.webbanhang.entity.ColorEntity;

@Component
public class ColorConverter {
	
	public ColorDTO toDto(ColorEntity entity){
		ColorDTO result = new ColorDTO();
		result.setId( entity.getId());
		result.setCode(entity.getCode());
		result.setName(entity.getName());
		return result;
	}
	
	public ColorEntity toEntity(ColorDTO dto){
		ColorEntity result = new ColorEntity();
		result.setCode(dto.getCode());
		result.setName(dto.getName());
		return result;
	}
}
