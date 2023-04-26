package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.ShoppingCartBean;

public interface ShoppingCartDao  extends JpaRepository<ShoppingCartBean, String>{
	@Query(value="insert into ShoppingCart(customer_id) select customer_id from Customers where customer_id=:id",nativeQuery = true)
	public void addCIdToSC(@Param(value="id") Integer id);

}
