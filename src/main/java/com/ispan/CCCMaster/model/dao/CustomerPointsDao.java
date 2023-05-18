package com.ispan.CCCMaster.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.customer.CustomerPoint;


public interface CustomerPointsDao extends JpaRepository<CustomerPoint,Integer>{

	@Query(value="select * from CustomerPoints where customer_id = :cid AND order_id = :oid AND plus_or_neg = 1",nativeQuery = true)
	public Optional<CustomerPoint> findPoints(@Param(value="cid")Integer customerId,@Param(value="oid")String orderid);
}
