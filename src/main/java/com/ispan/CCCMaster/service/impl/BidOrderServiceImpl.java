package com.ispan.CCCMaster.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.order.BidOrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.dao.BidOrderDao;
import com.ispan.CCCMaster.model.dao.BidProductDao;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.DealRecordDao;
import com.ispan.CCCMaster.service.BidOrderService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Service
public class BidOrderServiceImpl implements BidOrderService{
	
	@Autowired
	BidOrderDao boDao;
	
	@Autowired
	DealRecordDao recordDao;
	
	@Autowired
	CustomerDao cDao;
	
	@Autowired
	BidProductDao bpDao;

	//創立二手商品訂單
	@Override
	public void createBidOrder(BidOrderBean bidorder, Integer id) {
		Optional<BidProduct> option = bpDao.findById(id);
		DealRecord record = recordDao.findByBidProduct(option.get());
		Date date = new Date();
		//id	
		bidorder.setBidorderid(String.valueOf(date.getTime()));
		//運費
		bidorder.setFreight(30);
		//訂單狀態
		bidorder.setOrdercondition("處理中");
		//訂單日期
		bidorder.setOrderdate(date);
		//付款狀態
		bidorder.setPaymentcondition("未付款");
		//數量
		bidorder.setQuantity(1);
		//產品id		
		bidorder.setBpbidOrder(option.get());
		//賣家id
		bidorder.setCbSeller(option.get().getCustomer());
		//價格		
		bidorder.setPrice(record.getDealPrice());
		//買家id
		bidorder.setCbBuyer(record.getCustomer());
		boDao.save(bidorder);
	}
	
	//個人訂單最新一筆
	@Override
	public BidOrderBean findLatestByCid(Integer customerId) {
		Optional<BidOrderBean> option = boDao.findByCidByOrderDateDesc(customerId);
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}

	@Override
	@Transactional
	public String ecpayCheckout(Integer customerId,String bidorderid) {
		Date payDate = new Date();
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
		String form = all.aioCheckOut(obj, null);
		return form;
	}

	//依照訂單編號查詢
	@Override
	public BidOrderBean findById(String bidorderid) {
		Optional<BidOrderBean> option = boDao.findById(bidorderid);
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}

	@Override
	public List<BidOrderBean> findByCid(Integer customerId) {		
		return boDao.findByCid(customerId);
	}

	
	


}
