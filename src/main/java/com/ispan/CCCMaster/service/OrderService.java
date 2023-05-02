package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

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
	
	void createOrder(OrderBean orderBean);
	
//	String ecpayCheckout();

}