package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.service.OrderService;
import com.ispan.CCCMaster.service.ShoppingCartService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Controller
public class OrderAdminController {
	
	@Autowired
	OrderService oService;
    
	@Autowired
	private ShoppingCartService scService;
	
	
	//後台訂單列表	
	@GetMapping("/admin/orders")
	public String findAllOrder(Model model) {
		List<OrderBean> list = oService.findOrders();
		model.addAttribute("allorders",list);
		return "/back/order/showOrders";
	}	
	//後台單筆訂單
	@GetMapping("/admin/orders/editorder")
	public String findOrderById(@RequestParam("id") String orderid,Model model) {
		OrderBean ob= oService.findOrderByid(orderid);
		List<OrderDetailBean> odb = oService.findorderdetailbyOId(orderid);
		model.addAttribute("singleorder",ob);
		model.addAttribute("orderdetails",odb);
		return "/back/order/Order-edit";
	}	
//	//修改訂單
//	@PutMapping("/admin/orders/edit")
//	public String editOrderById(@ModelAttribute("singleorder")OrderBean orderBean) {
//		try {
//			oService.updateById(orderBean);
//		}catch(IOException e) {
//          e.printStackTrace();
//       }
//		return "redirect:/admin/orders";
//	}
//	
//
//	
	//新增訂單&同時刪掉購物車&修改存貨
	@PostMapping("/front/orders/create")
	public String createorder(@ModelAttribute("orderBean")OrderBean orderBean,
			@RequestParam("customerId")Integer customerId) throws IOException {
		oService.createOrder(orderBean,customerId);
		return "/front/orders/paymentorok";
	}
	//更新訂單內容
//	@PutMapping("/admin/orders/add")
//	public String addInfor(@ModelAttribute("order")OrderBean orderBean) {
//		try {
//			oService.updateById(orderBean);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return"/front/orders/checkorder";
//	}
	
	//前往綠界
	@ResponseBody
	@GetMapping("/ecpayCheckout")
	public String ecpayCheckout(@ModelAttribute("order")OrderBean order){
		String aioCheckOutALLForm = oService.ecpayCheckout(order);	
		return aioCheckOutALLForm;
	}
	
	
	
}
