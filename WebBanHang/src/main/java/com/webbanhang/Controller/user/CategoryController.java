package com.webbanhang.Controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.constant.SystemConstant;
import com.webbanhang.dto.ProductDTO;
import com.webbanhang.service.ICartService;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.IProductService;

@Controller(value="categoryControllerOfWeb")
public class CategoryController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ICartService cartService;
	
	@RequestMapping(value = {"/the-loai"} , method = RequestMethod.GET)
	public ModelAndView category(@RequestParam(value = "id") int id,
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/category");
		ProductDTO model = new ProductDTO();
		model.setId(id);
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);//từ vị trí thứ 0,giới hạn =2
		model.setListResult(categoryService.findAllByCategory(id, pageable));// findAll dựa trên phân trang
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));//tổng page = tổng số item / 2
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		mv.addObject("model", model);
		return mv;
	}
	
	@RequestMapping(value = "/chi-tiet" , method = RequestMethod.GET)
	public ModelAndView chitiet(@RequestParam(value = "id") int id,HttpServletRequest request) {
		  ModelAndView mv = new ModelAndView("user/product_detail");
	        mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
	        mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
	        // Lấy danh sách sản phẩm theo id thể loại
	        List<ProductDTO> productList = productService.findAllByCategory(id);
	        // Lấy thông tin sản phẩm theo id
	        ProductDTO model = productService.findProductById(id);
	        mv.addObject("model", model);
	        mv.addObject(SystemConstant.PRODUCT, productList);
		    return mv;
	}
}
