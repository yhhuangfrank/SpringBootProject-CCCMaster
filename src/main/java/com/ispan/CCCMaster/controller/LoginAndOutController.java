package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.service.LoginService;

@Controller
public class LoginAndOutController {
	
	@Autowired
	private LoginService lgService;
	
	@GetMapping("/login")	//前台登入頁面
	public String loginPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "front/login/login";
	}
	
	@PostMapping("/login")	//打完帳號密碼，送出表單
	public String login(@ModelAttribute("customer") Customer customer) {
		lgService
		return "redirect:/";	//回首頁	之後要改成回到上一個瀏覽畫面
	}

}
