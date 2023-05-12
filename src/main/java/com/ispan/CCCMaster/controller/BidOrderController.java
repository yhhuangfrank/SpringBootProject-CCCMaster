package com.ispan.CCCMaster.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.order.BidOrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.service.BidOrderService;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.DealRecordService;

@Controller
public class BidOrderController {
	
	@Autowired
	private DealRecordService recordService;
	
	@Autowired
	BidProductService bpService;
	
	@Autowired
	private BidOrderService borderService;
	
	//得到競標商品的最後一筆紀錄放進購物車
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart/bid")
	public String findLatestRecordByPid(@RequestParam("productId")BidProduct bidProduct,Model model) {
		DealRecord record= recordService.findByBidProduct(bidProduct);
		model.addAttribute("realrecord",record);
		return "/front/shoppingcarts/bidshoppingcart";
	}
	
	//確認填寫資訊
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart/bid/check")
	public String check(@RequestParam("productId")Integer id,Model model) {
		BidProduct bid = bpService.findBidProductById(id);
		DealRecord record= recordService.findByBidProduct(bid);
		model.addAttribute("realrecords",record);
		return "/front/orders/checkbid";
	}
	
	//成立二手商品訂單
	@CustomerAuthentication
	@PostMapping("/front/bidorders/create")
	public String creatbidorder(@ModelAttribute("bidorder")BidOrderBean bidorder,@RequestParam("productId")Integer id) {
		borderService.createbidorder(bidorder, id);
		return "redirect:/front/bidorders/bidpaymentorok";
	}
	//成立訂單通知
	@GetMapping("/front/bidorders/bidpaymentorok")
	public String findLatestOrderByCid(HttpSession session,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		BidOrderBean bidorder = borderService.findLatestByCid(customerId);
		model.addAttribute("latestbidorder",bidorder);
		return "/front/orders/bidpaymentorok";
	}
	
	//前往綠界付錢
	@ResponseBody
	@PostMapping("/ecpayCheckoutBid")
	public String ecpayCheckout(@RequestParam("customerId")Integer customerId){
		String aioCheckOutALLForm = borderService.ecpayCheckout(customerId);
		return aioCheckOutALLForm;
	}
	
	@Transactional
	@PostMapping("/front/bidorders/edit")
	public String returnURL(@RequestParam("MerchantTradeNo")String MerchantTradeNo,
							HttpServletRequest request) {
			String bidorderIdStr = MerchantTradeNo.substring(4);
			BidOrderBean bido = borderService.findById(bidorderIdStr);
			bido.setPaymentcondition("已付款");
			DealRecord record = recordService.findByBidProduct(bido.getBpbidOrder());
			record.setIsPaid(true);
			return "redirect:/";
	}


}
