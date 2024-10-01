package com.webbanhang.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.IProductService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {


	@Autowired
	private IProductService productService;

	@PostMapping("/api/new")
	@ResponseBody
	public ProductDTO createNew(@ModelAttribute  ProductDTO productDTO) {
		return productService.save(productDTO);
	}

	@PutMapping("/api/new")
	public ProductDTO updateNew(@ModelAttribute  ProductDTO updateNew) {
		return productService.save(updateNew);
	}

	@DeleteMapping("/api/new")
	public void deleteNew(@ModelAttribute  int[] ids) {
		productService.delete(ids);
	}

}
