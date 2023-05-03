package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	//訂單列表	
	@GetMapping("/admin/orders")
	public String findAllOrder(Model model) {
		List<OrderBean> list = oService.findOrders();
		List<OrderDetailBean> list2 = oService.findOrder();
		model.addAttribute("allorders",list);
		model.addAttribute("orderdetails",list2);
		return "/back/order/showOrders";
	}
	
	//單筆訂單
	@GetMapping("/admin/orders/editorder")
	public String findOrderById(@RequestParam("id") String orderid,Model model) {
		OrderBean ob= oService.findOrderByid(orderid);
		List<OrderDetailBean> list = oService.findOrder();
		model.addAttribute("singleorder",ob);
		model.addAttribute("orderdetails",list);
		return "/back/order/Order-edit";
	}
	
	//修改訂單
	@PutMapping("/admin/orders/edit")
	public String editOrderById(@ModelAttribute("singleorder")OrderBean orderBean) {
		try {
			oService.updateById(orderBean);
		}catch(IOException e) {
          e.printStackTrace();
       }
		return "redirect:/admin/orders";
	}
	
	//購物車列表
	@GetMapping("/front/shoppingcart/shoppingcartdetail")
	public String findSCByCid(Model model) {
		List<ShoppingCartBean> list = scService.findAll();
		model.addAttribute("orderBean", new OrderBean());
		model.addAttribute("orderbeandetail",new OrderDetailBean());
		model.addAttribute("shoppingcart",list);
		return "/front/shoppingcarts/showshoppingcartdetail";
	}
	
	//新增訂單
	@PostMapping("/admin/orders/create")
	public String createorder(@ModelAttribute("orderBean")OrderBean orderBean) {		
		oService.createOrder(orderBean);
		return "/front/orders/order";
	}
	
	//前往綠界
//	@GetMapping("/admin/ecpayCheckout")
//	public void ecpayCheckout(Model model,HttpServletRequest request,HttpServletResponse response,HttpSession session)throws IOException{
//		OrderBean ob = (OrderBean)request.getAttribute("orderBean");
//		//設定金流
//		AllInOne all = new AllInOne("");
//		AioCheckOutALL obj = new AioCheckOutALL();
//		//特店編號
//		obj.setMerchantID("2000214");
//		//交易時間
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		sdf.setLenient(false);
//		obj.setMerchantTradeDate(sdf.format(new Date()));
//		//交易編號
//		obj.setMerchantTradeNo("test"+ob.getOrderid());
//		//交易描述
//		obj.setTradeDesc("speakitup");
//		//付款完成，通知回傳網址
//		obj.setReturnURL("http://211.23.128.214:5000");
//		obj.setTotalAmount("50");
//		obj.setItemName("TestItem");
//		obj.setNeedExtraPaidInfo("N");
//		
//	}
}
