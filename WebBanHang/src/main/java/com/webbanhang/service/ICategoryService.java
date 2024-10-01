package com.webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.CategoryEntity;


@Service
public interface ICategoryService {
	public List<CategoryEntity> GetDataCategory();
	public List<ProductDTO> findAllByCategory(int categoryId,Pageable pageable);
	public ProductDTO findById(int id);
}
