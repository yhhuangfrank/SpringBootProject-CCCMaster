package com.ispan.CCCMaster.service;

import java.util.List;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.order.BidOrderBean;

public interface BidOrderService {

	//建立新的二手商品訂單
	public void createBidOrder(BidOrderBean bidorder,Integer id);
	
	//個人二手訂單最新一筆
	public BidOrderBean findLatestByCid(Integer customerId);
	
	//綠界
	String ecpayCheckout(Integer customerId,String bidorderid);
	
	//依照訂單編號查詢
	BidOrderBean findById(String bidorderid);
	
	//個人二手商品訂單清單
	List<BidOrderBean> findByCid(Integer customerId);
	
}
