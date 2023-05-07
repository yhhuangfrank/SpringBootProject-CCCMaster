package com.ispan.CCCMaster.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String createShoppingCart(@ModelAttribute("sc")ShoppingCartBean sc,
			@RequestParam("productId")Integer productId,
			HttpSession session) {
		Integer customerId=(Integer)(session.getAttribute("customerId"));
		if(customerId != null) {
			scService.createShoppingCart(sc,productId,customerId);
			return "redirect:/front/product/details/"+productId+"#";
		}else {
			return "front/login/login";
		}		
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
	//修改購物車購買數量
	@PutMapping("/front/shoppingcart")
	public String editBySCId(@ModelAttribute("shoppingcart")ShoppingCartBean shoppingcart) {
		try {
			scService.editBySCId(shoppingcart);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/front/shoppingcart";
	}
	//購物車資訊
	@GetMapping("/front/shoppingcart/shoppingcartdetail")
	public String findSCByCid(Model model) {
		List<ShoppingCartBean> list = scService.findAll();
		model.addAttribute("orderBean", new OrderBean());
		model.addAttribute("orderbeandetail",new OrderDetailBean());
		model.addAttribute("shoppingc",new ShoppingCartBean());
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcartdetail";
	}
	
	
	@PostMapping("/front/shoppingcart/shoppingcartdetail")
	public String saveInfoByCookie(@RequestParam("cookiescpayment")String cookiescpaymentvalue,
								@RequestParam("cookiescshipper")String cookiescshippervalue,
			HttpServletResponse response) {;
		Cookie cookiep = new Cookie("pay",cookiescpaymentvalue);
		cookiep.setPath("/");
		response.addCookie(cookiep);
		Cookie cookies = new Cookie("shi",cookiescshippervalue);
		cookies.setPath("/");
		response.addCookie(cookies);
		return "front/orders/checkorder";
	}
	
//	@GetMapping("/getcookie")
//	public String findCookie(HttpServletRequest request,Model model) {
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null) {
//			for(Cookie cookie:cookies) {
//				if(cookie.getName().equals("radio")) {
//					String cookiesvalue = cookie.getValue();
//					model.addAttribute("radio",cookiesvalue);
//				}else if(cookie.getName().equals("payment")) {
//					String cookiepvalue = cookie.getValue();
//					model.addAttribute("scpayment",cookiepvalue);
//				}
//				
//			}
//		}
//		return "front/orders/checkorder";
//	}

	

}
