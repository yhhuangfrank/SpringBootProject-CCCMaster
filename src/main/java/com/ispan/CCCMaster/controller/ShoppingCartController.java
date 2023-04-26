package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.model.bean.ShoppingCartBean;
import com.ispan.CCCMaster.model.bean.ShoppingCartDetailBean;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartService scService;

	@PostMapping("/ShoppingCarts/create")
	public String createShoppingCart(@ModelAttribute("sc")ShoppingCartBean sc) {
		scService.createShoppingCart(sc);
		return "redirect:/ShoppingCarts/createdetail";
	}
	@PostMapping("/ShoppingCarts/createdetail")
	public String createShoppingCartDetail(@ModelAttribute("scd")ShoppingCartDetailBean scd) {
		scService.createShoppingCartDetail(scd);
		return "front/frontExample";
	}
}
