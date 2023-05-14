package com.ispan.CCCMaster.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ispan.CCCMaster.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.service.OrderService;
import javax.persistence.criteria.Predicate;

@Controller
public class OrdersController {
	
	@Autowired
	OrderService oService;

	@Autowired
	CommentService commentService;
	
	@Autowired
	OrderDao oDao;
	
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
		OrderBean ob = oService.findOrderByid(orderid);
		List<OrderDetailBean> odb = oService.findorderdetailbyOId(orderid);
		for(OrderDetailBean od:odb) {
			System.out.println(od);
		}
		model.addAttribute("paymentCompleted",commentService.checkPaymentCompleted(orderid));//將付款狀態帶到 orderDetail 新增 by 暐翔
		model.addAttribute("orderdetails",odb);
		return "front/orders/orderdetail";
	}
	
	//查詢條件
	@GetMapping("/front/order/search")
	public String search(@RequestParam(name="type",defaultValue="orderid")String type,
							@RequestParam(name="keyword",defaultValue="")String keyword,
							Model model,HttpSession session) throws ParseException {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<OrderBean> result;
		if("orderid".equals(type)) {
			result = oService.findByOrderId(customerId, keyword);			
		}else {
			result = oService.findByDate(keyword);					
		}
		model.addAttribute("results",result);
		return "/front/orders/orders";
	}
}
