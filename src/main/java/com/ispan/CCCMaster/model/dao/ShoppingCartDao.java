package com.ispan.CCCMaster.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface ShoppingCartDao  extends JpaRepository<ShoppingCartBean, String>{

	@Query(value="delete from ShoppingCart where customer_id= :id",nativeQuery = true)
	public void deleteByCid(@Param(value="id") Integer id);
	
	@Query(value="select shoppoing_cart_id from ShoppingCart where customer_id= :id",nativeQuery = true)
	public String findByCid(@Param(value="id")Integer customerId);
	
	@Query(value="select * from ShoppingCart where product_id= :id",nativeQuery = true)
	public Optional<ShoppingCartBean> findByPid(@Param(value="id")Integer productId);
	
	

}
