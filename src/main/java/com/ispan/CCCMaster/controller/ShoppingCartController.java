//package com.ispan.CCCMaster.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.ispan.CCCMaster.model.bean.ShoppingCartBean;
//import com.ispan.CCCMaster.model.bean.weihsiang.Product;
//import com.ispan.CCCMaster.service.ShoppingCartService;
//
//@Controller
//public class ShoppingCartController {
//	
//	@Autowired
//	private ShoppingCartService scService;
//
//	@PostMapping("/ShoppingCarts/create")
//	public String createShoppingCart(@ModelAttribute("p")Product p) {
//		
//		return "單一商品的資訊頁";
//	}
//}
