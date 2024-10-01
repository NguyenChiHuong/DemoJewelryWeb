package com.webbanhang.Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.constant.SystemConstant;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.IProductService;
import com.webbanhang.service.ISlideService;

@Controller(value="homeControllerOfWeb")
public class HomeController{
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ISlideService slideService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = {"/","/trang-chu"} , method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView mv = new ModelAndView("user/home");
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		mv.addObject(SystemConstant.SLIDE, slideService.GetDataSlide());
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.PRODUCT, productService.getDataProduct());
		return mv;
	}
	
	@RequestMapping(value = "/dang-nhap" , method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		return mv;
	}
	
	
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) { //lệnh thoát không được null nếu không sẽ ko remove đc
			new SecurityContextLogoutHandler().logout(request, response, auth); //remove thông tin tài khoản khi thoát khỏi web
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied"); //Nếu nhận được quyền truy cập trái phép thì redirect
	}
	
	
	@RequestMapping(value = "/quen-matkhau" , method = RequestMethod.GET)
	public ModelAndView forget_password() {
		ModelAndView mv = new ModelAndView("user/forget_password");
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		return mv;
	}
	
	@RequestMapping(value = "/sosanh" , method = RequestMethod.GET)
	public ModelAndView sosanh() {
		ModelAndView mv = new ModelAndView("user/compair");
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		return mv;
	}
	
	
	@RequestMapping(value = "/lienhe" , method = RequestMethod.GET)
	public ModelAndView lienhe() {
		ModelAndView mv = new ModelAndView("user/contact");
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		return mv;
	}
}
