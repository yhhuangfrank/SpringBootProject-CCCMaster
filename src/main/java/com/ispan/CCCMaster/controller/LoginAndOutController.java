package com.ispan.CCCMaster.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.service.LoginService;

@Controller
public class LoginAndOutController {
	
	@Autowired
	private LoginService lgService;
	
	@GetMapping("/login")	//前台登入頁面
	public String loginPage() {
		return "front/login/login";
	}
	
	@PostMapping("/login")	//打完帳號密碼，送出表單
	public String login(@RequestParam("accountNumber") String accountNumber
						, @RequestParam("password") String password
						, HttpServletRequest request) {
		if(lgService.login(accountNumber, password, request)) {
			HttpSession session = request.getSession();
//			request.getHeader("Referer");	//取得目前瀏覽器的URL(以後可能會用到)
			return "redirect:/";	//回首頁	之後要改成回到上一個瀏覽畫面
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		lgService.logout(session);
		return "redirect:/";	//回首頁	之後要改成回到上一個瀏覽畫面
	}

}
