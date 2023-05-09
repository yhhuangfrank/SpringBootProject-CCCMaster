package com.ispan.CCCMaster.model.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;

public interface OrderDetailDao extends JpaRepository<OrderDetailBean, Integer>{

	@Query(value="select * from OrderDetail where order_id = :id", nativeQuery = true)
	public List<OrderDetailBean> findByOid(@Param(value="id") String orderid);
	
	
	
}
