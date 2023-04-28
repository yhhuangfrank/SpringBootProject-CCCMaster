package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;

public interface CouponService {

	//創造優惠券
	void createCoupon(CouponBean couponBean);

	//查詢單張優惠券
	CouponBean findCouponById(String couponid);

	//刪除優惠券
	void deleteCoupon(String couponid);

	//更新優惠券
	void updateCouponById(CouponBean couponBean) throws IOException;

	//更改時間格式:-字串->date->字串
	String changeSD(CouponBean cb) throws ParseException;

	//更改時間格式:-字串->date->字串
	String changeED(CouponBean cb) throws ParseException;

	//頁數
	Page<CouponBean> findByPage(Integer pageNumber);

}