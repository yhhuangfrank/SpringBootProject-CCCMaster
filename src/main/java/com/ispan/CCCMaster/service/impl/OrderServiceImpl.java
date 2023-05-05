package com.ispan.CCCMaster.service.impl;

import java.beans.Expression;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.service.OrderService;

import ecpay.logistics.integration.AllInOne;
import ecpay.logistics.integration.domain.CreateCVSObj;
import ecpay.logistics.integration.domain.ExpressMapObj;
//import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao oDao;
	
	@Autowired
	OrderDetailDao odDao;
	
	@Autowired
	ShoppingCartDao scDao;
	
	@Autowired
	ProductDao pDao;
	
	//依訂單編號找訂單
	@Override
	public OrderBean findOrderByid(String orderid) {
		Optional<OrderBean> option = oDao.findById(orderid);		
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}
	
	//找尋所有訂單
	@Override
	public List<OrderBean> findOrders() {
		return oDao.findAll();
	}
	
	//訂單詳細資料
	@Override
	public List<OrderDetailBean> findOrder(){
		return odDao.findAll();
	}
	
	//更改訂單資料
	@Override
	@Transactional
	public void updateById(OrderBean orderBean) throws IOException{
		Optional<OrderBean> option = oDao.findById(orderBean.getOrderid());
		if(option.isPresent()) {
			OrderBean oldOrder = option.get();
			oldOrder.setArrivaldate(orderBean.getArrivaldate());
			oldOrder.setShipperaddress(orderBean.getShipperaddress());
			oldOrder.setOrdercondition(orderBean.getOrdercondition());
			oldOrder.setShipperaddress(orderBean.getShipperaddress());
		}
		List<ShoppingCartBean> scBean = scDao.findAll();
		for(ShoppingCartBean sc : scBean) {
		//更新存貨
		Optional<Product> poption = pDao.findById(sc.getProductBean().getProductId());
		Optional<ShoppingCartBean> scoption = scDao.findByPid(sc.getProductBean().getProductId());
		if(option.isPresent()) {
			if(scoption.isPresent()) {				
				ShoppingCartBean oldsc = scoption.get();
				Integer min= oldsc.getQuantity();
				Product oldp = poption.get();
				Integer inventory = oldp.getInventory();
				inventory -= min;
				oldp.setInventory(inventory);
			}
		}			
	}
}
	//建立訂單
	@Override
	@Transactional
	public void createOrder(OrderBean order) throws IOException{
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());
		//id
		order.setOrderid(dateString);
		//日期
		order.setOrderdate(date);
		//訂單狀態
		order.setOrdercondition("處理中");
		//將購物車明細加入訂單明細內
		Set<OrderDetailBean> orderdetails = new HashSet<>();
		List<ShoppingCartBean> scBean = scDao.findAll();
		for(ShoppingCartBean sc : scBean) {
			OrderDetailBean od = new OrderDetailBean();
			od.setQuantity(sc.getQuantity());
			od.setUnitprice(sc.getUnitprice());
			od.setpOrderDetail(sc.getProductBean());
			od.setOrderBean(order);
			orderdetails.add(od);
		}
		//計算訂單總額
		Integer totalamount = 0;
		for(ShoppingCartBean sc : scBean) {		
			totalamount += sc.getQuantity()*sc.getUnitprice();			
		}
		if(totalamount >1000) {
			order.setFreight(0);
		}else {
			order.setFreight(30);
		}
		order.setTotalamount(totalamount);
		order.setSeto(orderdetails);
		
		oDao.save(order);
	}
	//訂單的詳細資料
	@Override
	public List<OrderDetailBean> findorderdetailbyOId(String orderid) {
		return odDao.findByOid(orderid);	  
	}

	
	//物流
//	@Override
//	public String ecpaylog() {
//		AllInOne all = new AllInOne("");
//		ExpressMapObj map= new ExpressMapObj();
//		map.setMerchantID("2000214");
//		map.setMerchantTradeNo("testCompany0004");
//		map.setIsCollection("NO");
//		map.setServerReplyURL("http://211.23.128.214:5000");
//		map.setLogisticsSubType("UNIMART");
//		String form = all.expressMap(map);
//		return form;
//	}

}
