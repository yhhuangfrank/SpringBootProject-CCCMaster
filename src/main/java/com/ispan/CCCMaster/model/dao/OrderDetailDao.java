package com.ispan.CCCMaster.model.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.OrderBean;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface OrderDetailDao extends JpaRepository<OrderDetailBean, Integer>{

	@Query(value="select * from OrderDetail where order_id = :id", nativeQuery = true)
	public List<OrderDetailBean> findByOid(@Param(value="id")String orderid);
	
	
	
}
