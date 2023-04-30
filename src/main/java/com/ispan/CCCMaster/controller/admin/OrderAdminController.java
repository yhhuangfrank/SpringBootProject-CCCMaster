package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.service.OrderService;

@Controller
public class OrderAdminController {
	
	@Autowired
	OrderService oService;

	
	//訂單列表	
	@GetMapping("/orders")
	public String findAllOrder(Model model) {
		List<OrderBean> list = oService.findOrders();
		List<OrderDetailBean> list2 = oService.findOrder();
		model.addAttribute("allorders",list);
		model.addAttribute("orderdetails",list2);
		return "/back/order/showOrders";
	}
	
	//單筆訂單
	@GetMapping("/orders/editorder")
	public String findOrderById(@RequestParam("id") String orderid,Model model) {
		OrderBean ob= oService.findOrderByid(orderid);
		List<OrderDetailBean> list = oService.findOrder();
		model.addAttribute("singleorder",ob);
		model.addAttribute("orderdetails",list);
		return "/back/order/Order-edit";
	}
	
	//修改訂單
	@PutMapping("/orders/edit")
	public String editOrderById(@ModelAttribute("singleorder")OrderBean orderBean) {
		try {
			oService.updateById(orderBean);
		}catch(IOException e) {
          e.printStackTrace();
       }
		return "redirect:/orders";
	}
	
	//新增訂單
	@PostMapping("/orders/create")
	public String createorder(@ModelAttribute("order") OrderBean o,OrderDetailBean od) {
		oService.createOrder(o, od);
		return "/front/shoppingcarts/showshoppingcart";
	}
}
