package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRange;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
	public String findAllOrder(@RequestParam(name="p", defaultValue = "1") Integer pageNumber,Model model) {
		Page<OrderBean> page = oService.findOrdersByPage(pageNumber);
		Page<OrderBean> handlingpage = oService.findHandingOrder(pageNumber);
		Page<OrderBean> unpaypage = oService.findUnpay(pageNumber);
		Page<OrderBean> cancelpage = oService.findCancelOrder(pageNumber);
		Page<OrderBean> refundpage = oService.findDefundOrder(pageNumber);
		model.addAttribute("page",page);
		model.addAttribute("handlingpage",handlingpage);
		model.addAttribute("unpaypage",unpaypage);
		model.addAttribute("cancelpage",cancelpage);
		model.addAttribute("refundpage",refundpage);
		return "/back/order/showOrders";
	}
	//查詢條件
	@GetMapping("/admin/orders/search")
	public String search(@RequestParam(name="type",defaultValue="orderid")String type,
						@RequestParam(name="keyword",defaultValue="")String keyword,
						Model model,HttpSession session) throws ParseException {
			Integer customerId = (Integer)session.getAttribute("customerId");
			List<OrderBean> result;
			List<OrderBean> handlingpage;
			List<OrderBean> unpaypage;
			List<OrderBean> cancelpage;
			List<OrderBean> refundpage;
			if("orderid".equals(type)) {
				result = oService.findByOidAdmin(keyword);
				handlingpage = oService.findByOidByHandling(keyword);
				unpaypage = oService.findByOidByUnpay(keyword);
				cancelpage = oService.findByOidByCancel(keyword);
				refundpage = oService.findByOidByRefund(keyword);
			}else {
				result = oService.findByDate(keyword);
				handlingpage = oService.findByDate(keyword);
				unpaypage = oService.findByDate(keyword);
				cancelpage = oService.findByDate(keyword);
				refundpage = oService.findByDate(keyword);
			}
				model.addAttribute("results",result);
				model.addAttribute("handlingpages",handlingpage);
				model.addAttribute("unpaypages",unpaypage);
				model.addAttribute("cancelpages",cancelpage);
				model.addAttribute("refundpages",refundpage);
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
		
	
	
	
	
	
	
	
}
