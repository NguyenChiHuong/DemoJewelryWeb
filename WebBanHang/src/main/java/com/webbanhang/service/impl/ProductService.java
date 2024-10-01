package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.ProductConverter;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.entity.CategoryEntity;
import com.webbanhang.entity.ColorEntity;
import com.webbanhang.entity.ProductEntity;
import com.webbanhang.repository.CategoryRepository;
import com.webbanhang.repository.ColorRepository;
import com.webbanhang.repository.ProductRepository;
import com.webbanhang.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<ProductDTO> getDataProduct() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();//select all item news from database put on list
		for(ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDto(item);//convert dto to entity post on client
			models.add(dto);
		}
        return models;
	}

	@Override
	public List<ProductDTO> findallproduct(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();//select all item news from database put on list
		for(ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDto(item);//convert dto to entity post on client
			models.add(dto);
		}
		return models;
	}

	@Override
	public Integer getTotalItem() {
		return (int) productRepository.count();
	}

	@Override
	public ProductDTO findProductById(int id) {
		ProductEntity item = productRepository.findOne(id);
	    return productConverter.toDto(item);
	}
	
	public List<ProductDTO> findAllByCategory(int id) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAllByCategoryId(id);
		for (ProductEntity item : entities) {
			ProductDTO dto = productConverter.toDto(item);
			models.add(dto);
		}
		return models;
	}

	@Override
	@Transactional
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode()); //get categorycode from client
		ColorEntity color = colorRepository.findOneByCode(dto.getColorCode()); //get clorCode from client
		ProductEntity productEntity = new ProductEntity();
		if(dto.getId() != null) {
			ProductEntity oldnew = productRepository.findOne(dto.getId()); // select one new throw id get from client
			productEntity = productConverter.toEntity(oldnew, dto);
		}else {
			productEntity = productConverter.toEntity(dto); //convert from dto to entity 
		}
		productEntity.setCategory(category); //set name category throw code category
		productEntity.setColor(color); //set name category throw code category
		return productConverter.toDto(productRepository.save(productEntity)); //insert or update to database and convert put/post on client 
	}

	@Override
	@Transactional
	public void delete(int[] ids) {
		for (int id : ids) {
			productRepository.delete(id);
		}
	}

}
