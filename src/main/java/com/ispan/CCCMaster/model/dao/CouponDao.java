package com.ispan.CCCMaster.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;


public interface CouponDao extends JpaRepository<CouponBean, String>{

	public CouponBean findByConvertid(String convertid);
		

}
