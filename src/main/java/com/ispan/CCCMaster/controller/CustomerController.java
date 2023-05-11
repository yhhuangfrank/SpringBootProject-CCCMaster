package com.ispan.CCCMaster.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService ctmService;
	
	@GetMapping("/login")	//前台會員登入頁面
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
//			return "redirect:/";	//回首頁
			return "redirect:" + referer;	//回到上一個瀏覽頁面；有小bug，不能打錯帳號密碼否則會出bug
		} else {
			//重導前添加登入失敗訊息
			redirectAttributes.addFlashAttribute("isFailed", true);
			redirectAttributes.addFlashAttribute("failedMsg", "登入失敗！請檢查您的帳號和密碼是否正確。");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")	//按下登出按鈕
	public String logOut(HttpSession session
						, RedirectAttributes redirectAttributes
						, HttpServletRequest request) {
		ctmService.logOut(session);
		//重導前添加登出成功訊息
		redirectAttributes.addFlashAttribute("logoutSuccess", true);
		redirectAttributes.addFlashAttribute("logoutSuccessMsg", "您已成功登出！欲使用更多功能請重新登入!");
		return "redirect:" + request.getHeader("Referer");	//回到上一個瀏覽頁面
	}
	
	@GetMapping("/signup")	//前台會員註冊頁面
	public String signupPage(Model model) {
		model.addAttribute("customer", new Customer());
		return "front/customer/signup";
	}
	
	@PostMapping("/signup")	//打完註冊資訊，送出表單
	public String signUp(@ModelAttribute("customer") Customer customer) {
		ctmService.createCustomer(customer);
		return "redirect:/";	//先改成到首頁，之後要改成自動登入並到首頁
	}

}
