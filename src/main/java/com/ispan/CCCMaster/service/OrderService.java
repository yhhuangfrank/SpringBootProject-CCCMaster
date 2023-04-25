package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.OrderBean;
import com.ispan.CCCMaster.model.bean.OrderDetailBean;
import com.ispan.CCCMaster.model.dao.OrderDao;
import com.ispan.CCCMaster.model.dao.OrderDetailDao;

@Service
public class OrderService {
	
	@Autowired
	OrderDao oDao;
	
	@Autowired
	OrderDetailDao odDao;
	
	//依訂單編號找訂單
	public OrderBean findOrderByid(String orderid) {
		Optional<OrderBean> option = oDao.findById(orderid);		
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}
	
	//找尋所有訂單
	public List<OrderBean> findOrders() {
		return oDao.findAll();
	}
	
	//訂單詳細資料
	public List<OrderDetailBean> findOrder(){
		return odDao.findAll();
	}
	
	//更改訂單資料
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
