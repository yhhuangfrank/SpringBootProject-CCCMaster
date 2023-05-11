package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.service.DealRecordService;

@Controller
public class BidOrderController {
	
	@Autowired
	private DealRecordService recordService;
	
	//得到競標商品的最後一筆紀錄放進購物車
	@CustomerAuthentication
	@GetMapping("/front/shoppingcart/bid")
	public String findLatestRecordByPid(@RequestParam("productId")BidProduct bidProduct,Model model) {
		DealRecord record= recordService.findByBidProduct(bidProduct);
		model.addAttribute("realrecord",record);
		return "/front/shoppingcarts/bidshoppingcart";
	}

}
