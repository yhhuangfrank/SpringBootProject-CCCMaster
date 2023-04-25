package com.ispan.CCCMaster.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.ispan.CCCMaster.model.bean.OrderBean;
import com.ispan.CCCMaster.model.bean.OrderDetailBean;
import com.ispan.CCCMaster.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService oService;

	
	//訂單列表	
	@GetMapping("/Orders")
	public String findAllOrder(Model model) {
		List<OrderBean> list = oService.findOrders();
		List<OrderDetailBean> list2 = oService.findOrder();
		model.addAttribute("allorders",list);
		model.addAttribute("orderdetails",list2);
		return "/back/order/showOrders";
	}
	
	//單筆訂單
	@GetMapping("/Orders/editOrder")
	public String findOrderById(@RequestParam("id") String orderid,Model model) {
		OrderBean ob= oService.findOrderByid(orderid);
		List<OrderDetailBean> list = oService.findOrder();
		model.addAttribute("singleorder",ob);
		model.addAttribute("orderdetails",list);
		return "/back/order/Order-edit";
	}
	
	//修改訂單
	@PutMapping("/Orders/edit")
	public String editOrderById(@ModelAttribute("singleorder")OrderBean orderBean) {
		try {
			oService.updateById(orderBean);
		}catch(IOException e) {
          e.printStackTrace();
       }
		return "redirect:/Orders";
	}
}
