package com.ispan.CCCMaster.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.service.CustomerService;
import com.ispan.CCCMaster.service.DealRecordService;
import com.ispan.CCCMaster.service.ProductService;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
    @Autowired
    private ProductService pService;
    
	@Autowired
	private ShoppingCartService scService;
	
	@Autowired
	private DealRecordService recordService;
	
	@Autowired
	private CustomerService cService;
	
	//創立購物車，並將畫面重新導向為商品詳細頁面
	@PostMapping("/shoppingcarts/create")
	public String createShoppingCart(@ModelAttribute("sc")ShoppingCartBean sc,
			@RequestParam("productId")Integer productId,
			@RequestParam("customerId")Integer customerId) {
			scService.createShoppingCart(sc, customerId,productId);		
			return "redirect:/front/product/details/"+productId+"#";
		}	

	//查詢購物車
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart")
	public String findShoppingCart(HttpSession session ,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<ShoppingCartBean> sc =  scService.findByCid(customerId);
		Customer customer= cService.findById(customerId);
		model.addAttribute("shoppingcart",sc);
		model.addAttribute("customer",customer);
		return "/front/shoppingcarts/showshoppingcart";
	}

	//刪除購物車
	@CustomerAuthentication
	@DeleteMapping("/front/shoppingcart/delete")
	public String deleteBySCId(@RequestParam("id") String shoppoingCartId) {
		scService.deleteBySCId(shoppoingCartId);
		return "redirect:/front/shoppingcart";
	}
	//修改購物車購買數量
	@CustomerAuthentication
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
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart/shoppingcartdetail")
	public String findSCByCid(HttpSession session,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<ShoppingCartBean> list =  scService.findByCid(customerId);
		model.addAttribute("orderBean", new OrderBean());
		model.addAttribute("shoppingc",new ShoppingCartBean());
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcartdetail";
	}
	//訂購詳細資訊
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart/shoppingcartdetail/check")
	public String checksc(HttpSession session ,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<ShoppingCartBean> sc =  scService.findByCid(customerId);
		model.addAttribute("shoppingcart",sc);
		return "front/orders/checkorder";
	}
	

	

}
