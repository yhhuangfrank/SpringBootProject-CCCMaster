package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginAndOutController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "front/login/login";
	}

}
