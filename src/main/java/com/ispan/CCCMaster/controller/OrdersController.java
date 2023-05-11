package com.ispan.CCCMaster.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.service.OrderService;

@Controller
public class OrdersController {
	
	@Autowired
	OrderService oService;
	
	//前台個人訂單清單
	@CustomerAuthentication
	@GetMapping("/front/orders")
	public String findByCId(HttpSession session ,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<OrderBean> list = oService.findOrderByCId(customerId);
		model.addAttribute("orders",list);
		return "/front/orders/orders";
	}

	//前台訂單的訂單明細
	@CustomerAuthentication
	@GetMapping("/front/orders/details/{orderid}")
	public String findDetailByOId(@PathVariable("orderid") String orderid, Model model) {
		System.out.println("OK");
		List<OrderDetailBean> odb = oService.findorderdetailbyOId(orderid);
		model.addAttribute("orderdetails",odb);
		return "front/orders/orderdetail";
	}
}
