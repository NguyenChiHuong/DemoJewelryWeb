package com.webbanhang.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.webbanhang.dto.ProductDTO;

@Service
public interface IProductService {
	 public List<ProductDTO> getDataProduct();
	 public List<ProductDTO> findallproduct(Pageable pageable);
	 public Integer getTotalItem();
	 public ProductDTO findProductById(int id);
	 public List<ProductDTO> findAllByCategory(int id);
	 
	 public ProductDTO save(ProductDTO dto);
	 public void delete(int[] ids);
}
