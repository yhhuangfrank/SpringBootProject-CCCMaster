package com.ispan.CCCMaster.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;
import com.ispan.CCCMaster.model.dao.CouponDao;
import com.ispan.CCCMaster.model.dao.CustomerCouponDao;
import com.ispan.CCCMaster.service.CustomerCouponService;
import com.ispan.CCCMaster.util.LoginUtil;

@Service
public class CustomerCouponServiceImpl implements CustomerCouponService {
	
	@Autowired
	private CustomerCouponDao ccDao;
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private LoginUtil loginUtil;
	
	@Override
	public Boolean createCustomerCoupon(HttpSession session, String convertid) {
		CouponBean foundCouponBean = couponDao.findByConvertid(convertid);
		if(foundCouponBean == null) return false;
		
		Customer foundCustomer = loginUtil.getLoginCustomer(session);
		CustomerCoupon customerCoupon = new CustomerCoupon();
		customerCoupon.setCustomers(foundCustomer);
		customerCoupon.setCouponBean(foundCouponBean);
		ccDao.save(customerCoupon);
		
		return true;
	}
	
	@Override
	public List<CustomerCoupon> findByCustomer(Customer customer) {
		List<CustomerCoupon> customerCoupons = ccDao.findByCustomers(customer);
		return customerCoupons;
	}

}
