package com.ispan.CCCMaster.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface ShoppingCartDao  extends JpaRepository<ShoppingCartBean, String>{

	@Modifying
	@Query(value="delete from ShoppingCart where customer_id= :id",nativeQuery = true)
	public void deleteByCid(@Param(value="id")Integer customerId);
	
	
	@Query(value="select * from ShoppingCart where customer_id= :id",nativeQuery = true)
	public List<ShoppingCartBean> findAllByCid(@Param(value="id")Integer customerId);
	
	@Query(value="select * from ShoppingCart where product_id= :id and customer_id= :cid",nativeQuery = true)
	public Optional<ShoppingCartBean> findByPidandCid(@Param(value="id")Integer productId,@Param(value="cid")Integer customerId);
}
