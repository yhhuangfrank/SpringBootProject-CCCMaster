package com.ispan.CCCMaster.model.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.OrderBean;


public interface OrderDao extends JpaRepository<OrderBean, String>{
	
	@Query(value="select * from Orders where customer_id= :id",nativeQuery = true)
	public List<OrderBean> findAllByCid(@Param(value="id")Integer customerId);
	
	@Query(value="select TOP (1) * from Orders where customer_id= :id order by order_date DESC",nativeQuery = true)
	public Optional<OrderBean> findByCidByOrderDateDesc(@Param(value="id")Integer customerId);


	
}
