package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webbanhang.converter.ProductConverter;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.repository.CategoryRepository;
import com.webbanhang.repository.ProductRepository;
import com.webbanhang.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	
	@Override
	public List<CategoryEntity> GetDataCategory() {
		List<CategoryEntity> list = new ArrayList<CategoryEntity>();
		list = categoryRepository.findAll();
		return list;
	}
	
	public List<ProductDTO> findAllByCategory(int id, Pageable pageable) {
	    List<ProductDTO> models = new ArrayList<>();
	    List<ProductEntity> entities = productRepository.findAllByCategoryId(id, pageable);
	    for (ProductEntity item : entities) {
	        ProductDTO dto = productConverter.toDto(item);
	        models.add(dto);
	    }
	    return models;
	}

	@Override
	public ProductDTO findById(int id) {
		ProductEntity item = productRepository.findOne(id);
		return  productConverter.toDto(item);
	}
}
