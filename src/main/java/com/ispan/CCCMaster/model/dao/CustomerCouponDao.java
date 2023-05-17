package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;

public interface CustomerCouponDao extends JpaRepository<CustomerCoupon, Integer> {

}
