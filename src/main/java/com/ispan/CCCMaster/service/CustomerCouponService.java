package com.ispan.CCCMaster.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;

public interface CustomerCouponService {

	Boolean createCustomerCoupon(HttpSession session, String convertid);

	List<CustomerCoupon> findByCustomer(Customer customer);

}
