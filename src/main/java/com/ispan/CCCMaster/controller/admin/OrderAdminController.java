package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		model.addAttribute("allorders",list);
		return "/back/order/showOrders";
	}	
	//單筆訂單
	@GetMapping("/admin/orders/editorder")
	public String findOrderById(@RequestParam("id") String orderid,Model model) {
		OrderBean ob= oService.findOrderByid(orderid);
		List<OrderDetailBean> odb = oService.findorderdetailbyOId(orderid);
		model.addAttribute("singleorder",ob);
		model.addAttribute("orderdetails",odb);
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
	
	//新增訂單&同時刪掉購物車&修改存貨
	@PostMapping("/front/orders/create")
	public String createorder(@ModelAttribute("orderBean")OrderBean orderBean) throws IOException {
		oService.createOrder(orderBean);
//		scService.deleteAll();
		return "/front/orders/order";
	}
	//前台訂單資料
//	@GetMapping("/front/orders")
//	public String findfrontorder(@PathVariable("id") String orderid,Model model) {
//		OrderBean ob= oService.findOrderByid(orderid);
//		List<OrderDetailBean> odb = oService.findorderdetailbyOId(orderid);
//		model.addAttribute("singleorder",ob);
//		model.addAttribute("orderdetails",odb);
//		return "/front/orders/order";
//	}
	//更新訂單內容
	@PutMapping("/admin/orders/add")
	public String addInfor(@ModelAttribute("order")OrderBean orderBean) {
		try {
			oService.updateById(orderBean);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return"/front/orders/checkorder";
	}
	
	
	//前往綠界
	@GetMapping("/admin/ecpayCheckout")
	public String ecpayCheckout(HttpServletRequest req,HttpServletResponse res)throws IOException{
		OrderBean ob= (OrderBean)req.getAttribute("order");
		//設定金流
		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();
		//特店編號
		obj.setMerchantID("2000214");
		//交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		obj.setMerchantTradeDate(sdf.format(new Date()));
		//交易編號
		obj.setMerchantTradeNo("test"+ob.getOrderid());
		//交易描述
		obj.setTradeDesc("speakitup");
		//付款完成，通知回傳網址
		obj.setReturnURL("http://211.23.128.214:5000");
		obj.setTotalAmount(String.valueOf(ob.getTotalamount()));
		obj.setItemName("TestItem");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		return form;
	}
	
	//物流
//	@GetMapping("/admin/ecpaylog")
//	public String ecpaylog() {
//		String form =  oService.ecpaylog();
//		return form;
//	}
	
}
