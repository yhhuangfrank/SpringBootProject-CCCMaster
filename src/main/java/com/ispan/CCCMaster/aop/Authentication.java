package com.ispan.CCCMaster.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Aspect
@Component
public class Authentication {
	
//	@Before("execution(* com.example.controller.*.*(..)) && @annotation(RequireSession)")
	@Before("@annotation(com.ispan.CCCMaster.annotation.CustomerAuthentication) && (args(session) || args(session, ..))")
	public void authenticateCustomer(HttpSession session) {
//		return "redirect:/login";
		System.out.println("========================");
		System.out.println("成功啦!JOJO!");
		System.out.println("========================");
	}

}
