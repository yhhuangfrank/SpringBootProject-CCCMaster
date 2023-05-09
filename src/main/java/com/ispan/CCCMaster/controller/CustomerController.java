package com.ispan.CCCMaster.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService ctmService;
	
	@GetMapping("/login")	//前台登入頁面
	public String loginPage(HttpServletRequest request) {
		String referer = request.getHeader("Referer");
		request.setAttribute("referer", referer);	//頁面跳轉前先把當時的URL儲存起來
		return "front/login/login";
	}
	
	@PostMapping("/login")	//打完帳號密碼，送出表單
	public String logIn(@RequestParam("accountNumber") String accountNumber
						, @RequestParam("password") String password
						, HttpServletRequest request
						, RedirectAttributes redirectAttributes
						, @RequestParam("referer") String referer) {
		if(ctmService.logIn(accountNumber, password, request)) {
			return "redirect:/";	//回到上一個瀏覽頁面；有bug未解，暫時先改成回首頁
		} else {
			//重導前添加登入失敗訊息
			redirectAttributes.addFlashAttribute("isFailed", true);
			redirectAttributes.addFlashAttribute("failedMsg", "登入失敗！請檢查您的帳號和密碼是否正確。");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session
						, RedirectAttributes redirectAttributes
						, HttpServletRequest request) {
		ctmService.logOut(session);
		redirectAttributes.addFlashAttribute("logoutSuccessful", true);	//重導前添加登出成功訊息
		return "redirect:" + request.getHeader("Referer");	//回到上一個瀏覽頁面
	}

}
