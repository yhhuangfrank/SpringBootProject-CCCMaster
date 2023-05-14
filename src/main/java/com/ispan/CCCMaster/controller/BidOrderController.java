package com.ispan.CCCMaster.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.ispan.CCCMaster.model.customexception.UnpayException;
import com.ispan.CCCMaster.model.dao.BidOrderDao;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.DealRecordDao;
import com.ispan.CCCMaster.service.BidOrderService;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.DealRecordService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Controller
public class BidOrderController {
	
	@Autowired
	BidOrderDao boDao;
	
	@Autowired
	DealRecordDao recordDao;
	
	@Autowired
	BidProductDao bpDao;
	
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
		Optional<BidProduct> option = bpDao.findById(bidProduct.getId());
		DealRecord dealrecord = recordDao.findByBidProduct(option.get());
		Long getDate= dealrecord.getCreatedAt().getTime();
		Date date = new Date();
		Long orderDate = date.getTime();
		Long days = orderDate-getDate;
		if(days<604800000) {
			DealRecord record= recordService.findByBidProduct(bidProduct);
			model.addAttribute("realrecord",record);
			return "/front/shoppingcarts/bidshoppingcart";
		}else {
			return "redirect:/front/unbidorder";
		}
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
		borderService.createBidOrder(bidorder, id);
		return "redirect:/front/bidorders/bidpaymentorok";
	}
	//成立訂單通知
	@CustomerAuthentication
	@GetMapping("/front/bidorders/bidpaymentorok")
	public String findLatestOrderByCid(HttpSession session,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		BidOrderBean bidorder = borderService.findLatestByCid(customerId);
		model.addAttribute("latestbidorder",bidorder);
		return "/front/orders/bidpaymentorok";
	}
	
	//時間過久未成立訂單
	@GetMapping("/front/unbidorder")
	public String noorder() {
		return "/front/orders/noorder";
	}
	
	//前往綠界付錢
	@ResponseBody
	@PostMapping("/ecpayCheckoutBid")
	public String ecpayCheckout(@RequestParam("customerId")Integer customerId,@RequestParam("bidorderid")String bidorderid){
		Optional<BidOrderBean> booption = boDao.findById(bidorderid);
		Date payDate = new Date();
		Long longpayDate = payDate.getTime();
		if(booption.isPresent()) {
			Long orderdate = booption.get().getOrderdate().getTime();
			Long days = longpayDate-orderdate;
			if(days<259200000) {
				AllInOne all = new AllInOne("");
				AioCheckOutALL obj = new AioCheckOutALL();
				//特店編號
				obj.setMerchantID("3002607");
				//交易時間
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				sdf.setLenient(false);
				obj.setMerchantTradeDate(sdf.format(payDate));
				//交易金額
				Optional<BidOrderBean>option = boDao.findByCidByOrderDateDesc(customerId);
				if(option.isPresent()) {
					BidOrderBean bidorder = option.get();
					String payamounts = String.valueOf(bidorder.getPrice()+bidorder.getFreight());
					obj.setTotalAmount(payamounts);
					//交易編號	
					obj.setMerchantTradeNo("test"+bidorder.getBidorderid());
				}
				//交易描述
				obj.setTradeDesc("test Description");
				//商品名稱
				obj.setItemName("3C商品");
				obj.setReturnURL("http://localhost:8080/returnURL");
				//付完後回到首頁
				obj.setOrderResultURL("http://localhost:8080/front/bidorders/edit");
				obj.setNeedExtraPaidInfo("N");
				String aioCheckOutALLForm = all.aioCheckOut(obj, null);
				return aioCheckOutALLForm;
			}else {
				BidOrderBean bidorder = booption.get();
				bidorder.setOrdercondition("已取消");
				bidorder.setPaymentcondition("逾期未付款");
				boDao.save(bidorder);
				throw new UnpayException();
			}			
		}
		return "/front/frontExample";
	}
	
	//逾期未付款畫面
	@GetMapping("/front/bidorders/unpay")
	public String nopay() {
		return "/front/orders/nopay";
	}
	
	//付完款，狀態處理
	@Transactional
	@PostMapping("/front/bidorders/edit")
	public String returnURL(@RequestParam("MerchantTradeNo")String MerchantTradeNo,
							HttpServletRequest request) {
			String bidorderIdStr = MerchantTradeNo.substring(4);
			BidOrderBean bido = borderService.findById(bidorderIdStr);
			bido.setPaymentcondition("已付款");
			DealRecord record = recordService.findByBidProduct(bido.getBpbidOrder());
			record.setIsPaid(true);
			return "redirect:/front/bidorders";
	}
	
	//二手商品訂單清單
	@GetMapping("/front/bidorders")
	public String findByCid(HttpSession session ,Model model) {
		Integer customerId = (Integer)session.getAttribute("customerId");
		List<BidOrderBean> list = borderService.findByCid(customerId);
		model.addAttribute("bidorders",list);
		return "/front/orders/bidorders";
	}


}
