package com.webbanhang.converter;

import org.springframework.stereotype.Component;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.ProductEntity;

@Component
public class ProductConverter {
	public ProductDTO toDto(ProductEntity entity) {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setDetail(entity.getDetail());
		result.setSize(entity.getSize());
		result.setImg(entity.getImg());
		result.setName(entity.getName());
		result.setTitle(entity.getTitle());
		result.setSale(entity.getSale());
		result.setPrice(entity.getPrice());
		result.setColorCode(entity.getColor().getCode());
		result.setCategoryCode(entity.getCategory().getCode());
		result.setColorName(entity.getColor().getName());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) {
		ProductEntity result = new ProductEntity();
		result.setTitle(dto.getTitle());
		result.setDetail(dto.getDetail());
		result.setSize(dto.getSize());
		result.setImg(dto.getImg());
		result.setName(dto.getName());
		result.setTitle(dto.getTitle());
		result.setPrice(dto.getPrice());
		result.setSale(dto.getSale());
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity entity,ProductDTO dto) {
		entity.setTitle(dto.getTitle());
		entity.setDetail(dto.getDetail());
		entity.setPrice(dto.getPrice());
		entity.setSize(dto.getSize());
		entity.setImg(dto.getImg());
		entity.setName(dto.getName());
		entity.setTitle(dto.getTitle());
		entity.setSale(dto.getSale());
		return entity;
	}
	
}
