package com.ispan.CCCMaster.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;


public interface CouponDao extends JpaRepository<CouponBean, String>{
	
	@Query(value="select * , convert(char(16),start_date,120),convert(char(16),end_date,120) from Coupon", nativeQuery = true)
	public List<CouponBean> findAllCoupons();


}
