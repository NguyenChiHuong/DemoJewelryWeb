package com.webbanhang.Controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webbanhang.constant.SystemConstant;
import com.webbanhang.dto.BillDTO;
import com.webbanhang.dto.CartDTO;
import com.webbanhang.dto.MyUser;
import com.webbanhang.dto.UserInfo;
import com.webbanhang.entity.BillEntity;
import com.webbanhang.entity.UserEntity;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.impl.BillDetaiService;

@Controller(value="payControllerOfWeb")
public class PayController {
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private BillDetaiService billDetaiService;
	
	@RequestMapping(value = "/thanh-toan", method = RequestMethod.GET)
	public ModelAndView checkOut(HttpServletRequest request, HttpSession session,Authentication authentication) {
	    ModelAndView mv = new ModelAndView("user/checkout");
	    // Lấy thông tin người dùng từ session (hoặc từ bất kỳ nguồn nào khác)
	    if (authentication != null && authentication.isAuthenticated()) {
	        // Lấy thông tin người dùng từ đối tượng Authentication
	        MyUser myUser = (MyUser) authentication.getPrincipal();
	        
	        // Tạo đối tượng BillDTO và set thông tin người dùng vào
	        BillDTO bill = new BillDTO();
	        bill.setName(myUser.getFullName());
	        bill.setEmail(myUser.getEmail());

	        mv.addObject("bill", bill);
	    }

	    mv.addObject(SystemConstant.CATEGORY, categoryService.GetDataCategory());
	    mv.addObject(SystemConstant.MENU, menuService.GetDataMenu()); 
	    return mv;
	}

	
	@RequestMapping(value = "/thanh-toan" , method = RequestMethod.POST)
	public String thanhToan(HttpServletRequest request ,HttpSession session,@ModelAttribute("bill") BillDTO bill) {
		bill.setQuanTy((int) session.getAttribute("totalQuanTyCart"));
		bill.setTotal((double) session.getAttribute("totalPriceCart"));
		if(billDetaiService.addBill(bill) != null) {
			HashMap<Integer, CartDTO> carts = (HashMap<Integer, CartDTO>) session.getAttribute("Cart");
			billDetaiService.addBillDetail(carts);
		}
		session.removeAttribute("Cart");
		session.setAttribute("totalQuanTyCart", 0);
	    session.setAttribute("totalPriceCart", 0.0);
		return "redirect:giohang";
	}
}
