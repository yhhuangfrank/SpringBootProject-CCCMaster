package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.order.BidOrderBean;

public interface BidOrderService {

	//創立bidorder訂單
	public void createbidorder(BidOrderBean bidorder,Integer customerId);
	
	//個人二手訂單最新一筆
	public BidOrderBean findLatestByCid(Integer customerId);
	
	//綠界
	String ecpayCheckout(Integer customerId);
	
	//依照訂單編號查詢
	BidOrderBean findById(String bidorderid);
	
	//棄標處理
}
