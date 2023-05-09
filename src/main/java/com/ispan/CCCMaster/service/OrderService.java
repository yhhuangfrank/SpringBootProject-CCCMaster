package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;

public interface OrderService {

	//依訂單編號找訂單
	OrderBean findOrderByid(String orderid);

	//找尋所有訂單
	List<OrderBean> findOrders();

	//訂單詳細資料
	List<OrderDetailBean> findOrder();

	//更改訂單資料
	void updateById(OrderBean orderBean) throws IOException;
	
	//創立訂單
	void createOrder(OrderBean order) throws IOException;
	
	//依照訂單找尋各自的訂單詳細資料
	List<OrderDetailBean> findorderdetailbyOId(String orderid);
	
//	String ecpayCheckout();
	
//	String ecpaylog();

}