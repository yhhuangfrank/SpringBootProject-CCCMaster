package com.ispan.CCCMaster.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;

public interface CustomerCouponDao extends JpaRepository<CustomerCoupon, Integer> {
	
	List<CustomerCoupon> findByCustomers(Customer customer);
	
	//by瑛仁
	@Query(value="select * from CustomerCoupons where customer_id= :cid AND convert_id= :couid",nativeQuery = true)
	public Optional<CustomerCoupon> findByCidByCouid(@Param(value="cid")Integer customerId,@Param(value="couid")String convertid);
	
	@Query("FROM CustomerCoupon as cc WHERE cc.customers.customerId = :customerId AND cc.isAvailable = true")
	List<CustomerCoupon> findByCustomerWhereIsAvailable(@Param("customerId") Integer customerId);

}
