package com.ispan.CCCMaster.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;

public interface CustomerCouponDao extends JpaRepository<CustomerCoupon, Integer> {
	
	List<CustomerCoupon> findByCustomers(Customer customer);

}
