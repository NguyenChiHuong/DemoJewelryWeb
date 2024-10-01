package com.webbanhang.Controller.user;

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
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.IProductService;

@Controller(value="productControllerOfWeb")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping(value = {"/san-pham"} , method = RequestMethod.GET)
	public ModelAndView Product(@RequestParam("page") int page,
			@RequestParam("limit") int limit,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/product");
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		model.setLimit(limit);
		Pageable pageable = new PageRequest(page - 1, limit);//từ vị trí thứ 0,giới hạn =9
		model.setListResult(productService.findallproduct(pageable));// findAll dựa trên phân trang
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));//tổng page = tổng số item / 9
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		mv.addObject("model", model);
		return mv;
	}
	
}
