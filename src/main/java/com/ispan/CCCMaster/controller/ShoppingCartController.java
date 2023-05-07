package com.ispan.CCCMaster.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartDetailBean;
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
	public String createShoppingCart(@ModelAttribute("sc")ShoppingCartBean sc,@RequestParam("productId")Integer productId,@RequestParam("customerId")Integer customerId) {
		scService.createShoppingCart(sc,productId,customerId);
		return "redirect:/front/product/details/"+productId+"#";
	}
	
	//查詢購物車
//	@GetMapping("/front/shoppingcart/shoppingcartdetail")
//	public String findShoppingCart(@RequestParam("id") Integer customerId ,Model model) {
//		List<ShoppingCartBean> list =  scService.findShoppingCartByCid(customerId);
//		model.addAttribute("orderBean", new OrderBean());
//		model.addAttribute("orderbeandetail",new OrderDetailBean());
//		model.addAttribute("sc",list);
//		return "front/shoppingcart/shoppingcart";
//	}
//	//購物車列表(可更改數量)
	@GetMapping("/front/shoppingcart")
	public String finaAll(Model model) {
		List<ShoppingCartBean> list = scService.findAll();
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcart";
	}
	//刪除購物車
	@DeleteMapping("/front/shoppingcart/delete")
	public String deleteBySCId(@RequestParam("id") String shoppoingCartId) {
		scService.deleteBySCId(shoppoingCartId);
		return "redirect:/front/shoppingcart";
	}
	//修改購物車
	@PutMapping("/front/shoppingcart")
	public String editBySCId(@ModelAttribute("shoppingcart")ShoppingCartBean shoppingcart) {
		try {
			scService.editBySCId(shoppingcart);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/front/shoppingcart";
	}
	//購物車列表
	@GetMapping("/front/shoppingcart/shoppingcartdetail")
	public String findSCByCid(Model model) {
		List<ShoppingCartBean> list = scService.findAll();
		model.addAttribute("orderBean", new OrderBean());
		model.addAttribute("orderbeandetail",new OrderDetailBean());
		model.addAttribute("sc",new ShoppingCartBean());
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcartdetail";
	}
	
	//修改購物車詳細資料
	@PutMapping("/front/shoppingcart/shoppingcartdetail")
	public String adddetail(@ModelAttribute("sc")ShoppingCartBean shoppingcart) {
		try {
			scService.editBySCId(shoppingcart);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "/front/orders/checkorder";
	}
	


	

}
