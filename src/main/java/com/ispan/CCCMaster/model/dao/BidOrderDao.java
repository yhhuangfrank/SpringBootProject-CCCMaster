package com.ispan.CCCMaster.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.BidOrderBean;

public interface BidOrderDao extends JpaRepository<BidOrderBean,String>{
	
	@Query(value="select TOP (1) * from BidOrder where buyer_id= :id order by order_date DESC",nativeQuery = true)
	public Optional<BidOrderBean> findByCidByOrderDateDesc(@Param(value="id")Integer customerId);

}
