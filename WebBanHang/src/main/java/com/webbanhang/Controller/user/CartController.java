package com.webbanhang.Controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.constant.SystemConstant;
import com.webbanhang.dto.CartDTO;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.impl.CartService;

@Controller(value="cartControllerOfWeb")
public class CartController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value = "/giohang" , method = RequestMethod.GET)
	public ModelAndView giohang() {
		ModelAndView mv = new ModelAndView("user/carts");
		mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
		mv.addObject(SystemConstant.MENU, menuService.GetDataMenu());
		return mv;
	}
	
	@RequestMapping(value = "/addCart/{id}")
	public String addCart(HttpSession session,@PathVariable int id,HttpServletRequest request) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		if (cart == null) { /* nếu cart chưa có gì thì tạo hashmap lưu chữ sản phẩm giỏ hàng*/
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.addCart(id, cart); /* Thêm giỏ hàng */
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuanTyCart", cartService.totalQuanTy(cart));/* hiển thị tổng số lượng product */
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart)); /* hiển thị tổng giá product */
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/editCart/{id}/{quanTy}")
	public String editCart(HttpSession session,@PathVariable int id,@PathVariable int quanTy,HttpServletRequest request) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		if (cart == null) { /* nếu cart chưa có gì thì tạo hashmap lưu chữ sản phẩm giỏ hàng*/
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.editCart(id, quanTy, cart); /* Sửa giỏ hàng */
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuanTyCart", cartService.totalQuanTy(cart));/* hiển thị tổng số lượng product */
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart)); /* hiển thị tổng giá product */
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/deleteCart/{id}")
	public String deleteCart(HttpSession session,@PathVariable int id,HttpServletRequest request) {
		HashMap<Integer, CartDTO> cart = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
		if (cart == null) { /* nếu cart chưa có gì thì tạo hashmap lưu chữ sản phẩm giỏ hàng*/
			cart = new HashMap<Integer, CartDTO>();
		}
		cart = cartService.deleteCart(id, cart); /* xóa sản phẩm */
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuanTyCart", cartService.totalQuanTy(cart));/* hiển thị tổng số lượng product */
		session.setAttribute("totalPriceCart", cartService.totalPrice(cart)); /* hiển thị tổng giá product */
		return "redirect:"+request.getHeader("Referer");
	}
}
