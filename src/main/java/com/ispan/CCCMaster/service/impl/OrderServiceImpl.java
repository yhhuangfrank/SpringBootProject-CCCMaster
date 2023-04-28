package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;
import com.ispan.CCCMaster.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao oDao;
	
	@Autowired
	OrderDetailDao odDao;
	
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
		}
	}

}
