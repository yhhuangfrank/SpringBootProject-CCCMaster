package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.ShoppingCartDetailBean;

public interface ShoppingCartDetailDao extends JpaRepository<ShoppingCartDetailBean, Integer>{
	
	@Query(value="insert into ShoppingCartDetail(product_id) select product_id from Products where product_id=:id",nativeQuery = true)
	public void addPIdToSCD(@Param(value="id") Integer id);

}
