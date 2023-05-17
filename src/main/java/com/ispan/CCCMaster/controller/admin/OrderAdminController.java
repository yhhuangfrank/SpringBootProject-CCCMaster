package com.ispan.CCCMaster.controller.admin;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerPoint;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.CustomerPointsDao;
import com.ispan.CCCMaster.model.dao.OrderDao;
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
	
	@Autowired
	CustomerPointsDao pointDao;
	
	@Autowired
	OrderDao oDao;
	
	@Autowired
	CustomerDao cDao;
	
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
		
	//新增訂單&同時刪掉購物車&修改存貨
	@PostMapping("/front/orders/create")
	public String createorder(@ModelAttribute("orderBean")OrderBean orderBean,
			@RequestParam("customerId")Integer customerId) throws IOException {
		oService.createOrder(orderBean,customerId);
		return "redirect:/front/orders/paymentorok";
	}
	
	//確認訂購資訊
	@GetMapping("/front/orders/paymentorok")
	public String findLatestOrderByCid(HttpSession session,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		OrderBean order = oService.findLatestByCid(customerId);
		model.addAttribute("latestorder",order);
		return "/front/orders/paymentorok";
	}
	
	//前往綠界付錢
	@ResponseBody
	@PostMapping("/ecpayCheckout")
	public String ecpayCheckout(@RequestParam("customerId")Integer customerId){
		String aioCheckOutALLForm = oService.ecpayCheckout(customerId);	
		return aioCheckOutALLForm;
	}
	
	//付完錢，回到頁面時要做的事情
	@Transactional
	@PostMapping("/front/orders/edit")
	public String returnURL(@RequestParam("MerchantTradeNo")String MerchantTradeNo,
							HttpServletRequest request) {
			String orderIdStr = MerchantTradeNo.substring(2);
			OrderBean ob = oService.findOrderByid(orderIdStr);
			ob.setPaymentcondition("已付款");
			return "redirect:/front/orders";
	}
	
	//給予點數
	@Transactional
	@PostMapping("/admin/givepoints")
	public String givepoints(@ModelAttribute("point")CustomerPoint point,
							@RequestParam("customerId")Integer customerId,
							@RequestParam("orderid")String orderid,
							Model model,
							RedirectAttributes redirectAttributes) throws IOException {
		Optional<OrderBean> option = oDao.findById(orderid);
		Optional<Customer> coption = cDao.findById(customerId);
		Integer total= option.get().getTotalamount();
		Optional<CustomerPoint> points = pointDao.findPoints(customerId, orderid);
		if(points.isPresent()) {
			redirectAttributes.addFlashAttribute("isFailed",true);
			redirectAttributes.addFlashAttribute("failedMsg","此筆訂單已給過點數!");
		}else {
			//新增紀錄
			oService.givePoints(point, customerId, orderid);	
			//給予會員點數					
			Integer startpoint = coption.get().getPoint();
			Integer givepoint = startpoint+total;
			coption.get().setPoint(givepoint);
			redirectAttributes.addFlashAttribute("isSuccess",true);
			redirectAttributes.addFlashAttribute("successMsg","此筆訂單成功給予點數!");
		}
		
			return "redirect:/admin/orders/editorder?id=" + orderid +"#";
		}
	
	
}
