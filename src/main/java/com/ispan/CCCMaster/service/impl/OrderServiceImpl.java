package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.service.OrderService;

import ecpay.payment.integration.AllInOne;
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
	
	@Autowired
	CustomerDao cDao;
	

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
//	@Override
//	@Transactional
//	public void updateById(OrderBean orderBean) throws IOException{
//		Optional<OrderBean> option = oDao.findById(orderBean.getOrderid());
//		if(option.isPresent()) {
//			OrderBean oldOrder = option.get();
//			oldOrder.setArrivaldate(orderBean.getArrivaldate());
//			oldOrder.setShipperaddress(orderBean.getShipperaddress());
//			oldOrder.setOrdercondition(orderBean.getOrdercondition());
//			oldOrder.setShipperaddress(orderBean.getShipperaddress());
//		}
//		List<ShoppingCartBean> scBean = scDao.findAll();
//		for(ShoppingCartBean sc : scBean) {
//		
//	}
//}
	//建立訂單
	@Override
	@Transactional
	public void createOrder(OrderBean order,Integer customerId) throws IOException{
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());
		//id
		order.setOrderid(dateString);
		//日期
		order.setOrderdate(date);
		//訂單狀態
		order.setOrdercondition("處理中");
		order.setPaymentcondition("未付款");
		//customerid
		Optional<Customer> cOption = cDao.findById(customerId);
		Customer c = cOption.get();
		order.setCbOrder(c);
		//將購物車明細加入訂單明細內
		Set<OrderDetailBean> orderdetails = new HashSet<>();
		List<ShoppingCartBean> scBean = scDao.findAllByCid(customerId);
		for(ShoppingCartBean sc : scBean) {
			OrderDetailBean od = new OrderDetailBean();
			od.setQuantity(sc.getScquantity());
			od.setUnitprice(sc.getUnitprice());
			od.setpOrderDetail(sc.getProductBean());
			od.setOrderBean(order);
			orderdetails.add(od);
			//更新存貨
			Optional<Product> poption = pDao.findById(sc.getProductBean().getProductId());
			Optional<ShoppingCartBean> scoption = scDao.findByPidandCid(sc.getProductBean().getProductId(),sc.getCbShoppingCart().getCustomerId());
			if(poption.isPresent()) {
				if(scoption.isPresent()) {				
					ShoppingCartBean oldsc = scoption.get();
					Integer min= oldsc.getScquantity();
					Product oldp = poption.get();
					Integer inventory = oldp.getInventory();
					inventory -= min;
					oldp.setInventory(inventory);
				}
			}
		}
		//計算訂單總額
		Integer totalamount = 0;
		for(ShoppingCartBean sc : scBean) {		
			totalamount += sc.getScquantity()*sc.getUnitprice();			
		}
		if(totalamount >1000) {
			order.setFreight(0);
		}else {
			order.setFreight(30);
		}
		order.setTotalamount(totalamount);
		order.setSeto(orderdetails);
		oDao.save(order);
		//刪除購物車
		scDao.deleteByCid(customerId);
	}

	//訂單的詳細資料
	@Override
	public List<OrderDetailBean> findorderdetailbyOId(String orderid) {
		return odDao.findByOid(orderid);	  
	}

	//金流
	@Override
	public String ecpayCheckout(OrderBean order) {
		String uuId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		AllInOne all = new AllInOne("");
		AioCheckOutALL obj = new AioCheckOutALL();
		
		//特店編號
		obj.setMerchantID("3002607");
		//交易編號
		obj.setMerchantTradeNo(uuId);
		//交易時間
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		Date date = new Date();
		obj.setMerchantTradeDate(sdf.format(date));
		//交易金額
//		String payamounts = String.valueOf(order.getTotalamount()+order.getFreight());
		obj.setTotalAmount("50");
		//交易描述
		obj.setTradeDesc("test Description");
		//商品名稱
		obj.setItemName("3C商品");
		obj.setReturnURL("http://211.23.128.214:5000");
		//付完後回到首頁
		obj.setClientBackURL("http://localhost:8080/");
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		
		return form;
	}

	//個人的訂單清單
	@Override
	public List<OrderBean> findOrderByCId(Integer customerId) {
		return oDao.findAllByCid(customerId);
	}

	


	// orderDetailId 找 orderDetail by 暐翔
	@Override
	public OrderDetailBean findOrderDetailById(Integer id){
		Optional<OrderDetailBean> optional=odDao.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}

}
