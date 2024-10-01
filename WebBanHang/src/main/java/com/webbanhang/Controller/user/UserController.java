package com.webbanhang.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webbanhang.constant.SystemConstant;
import com.webbanhang.dto.UserInfo;
import com.webbanhang.service.ICategoryService;
import com.webbanhang.service.IMenuService;
import com.webbanhang.service.IUserService;

@Controller(value = "userControllerOfWeb")
public class UserController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IUserService userService;
    
    @GetMapping(value = "/dang-ki")
    public String register(Model mv) {
    	mv.addAttribute("User", new UserInfo());
    	mv.addAttribute(SystemConstant.MENU, menuService.GetDataMenu());
    	mv.addAttribute(SystemConstant.CATEGORY, categoryService.GetDataCategory());
        return "user/register";
    }


    @PostMapping(value = "/dang-ki")
    public String createAccount(@ModelAttribute("User") UserInfo user) {
    	userService.save(user);
    	return "redirect:/dang-nhap";
    }
}
