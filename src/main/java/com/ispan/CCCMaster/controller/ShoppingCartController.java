package com.ispan.CCCMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ispan.CCCMaster.model.bean.ShoppingCartBean;
import com.ispan.CCCMaster.service.ProductService;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
    @Autowired
    private ProductService pService;
    
	@Autowired
	private ShoppingCartService scService;


	//創立購物車，並將畫面重新導向為商品詳細頁面
	@PostMapping("/shoppingcarts/create")
	public String createShoppingCart(@ModelAttribute("sc")ShoppingCartBean sc,@RequestParam("productId")Integer productId) {
		scService.createShoppingCart(sc, productId);
		return "redirect:/front/product/details/"+productId+"#";
	}
	
	//查詢購物車
//	@GetMapping("/front/shoppingcart")
//	public String findShoppingCart(@RequestParam("id") Customers c,Model model) {
//		List<ShoppingCartBean> list =  scService.findShoppingCartByCid(c);
//		model.addAttribute("sc",list);
//		return "front/shoppingcart/shoppingcart";
//	}
	
	@GetMapping("/front/shoppingcart")
	public String finaAll(Model model) {
		List<ShoppingCartBean> list = scService.findtest();
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcart";
	}
	
	

	

}
