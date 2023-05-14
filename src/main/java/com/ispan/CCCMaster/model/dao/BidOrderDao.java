package com.ispan.CCCMaster.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.order.BidOrderBean;

public interface BidOrderDao extends JpaRepository<BidOrderBean,String>{
	
	@Query(value="select TOP (1) * from BidOrder where buyer_id= :id order by order_date DESC",nativeQuery = true)
	public Optional<BidOrderBean> findByCidByOrderDateDesc(@Param(value="id")Integer customerId);
	
	@Query(value="select * from BidOrder where buyer_id= :id",nativeQuery = true)
	public List<BidOrderBean> findByCid(@Param(value="id")Integer customerId);
	
	//編號的查詢條件
	@Query(value="select * from BidOrder where buyer_id= :bid AND bid_order_id LIKE %:oid% order by order_date DESC",nativeQuery = true)
	public List<BidOrderBean> findByCidByIdContainingByOrderDateDesc(@Param(value="cid")Integer customerId,@Param(value="oid")String bidorderid);

}
