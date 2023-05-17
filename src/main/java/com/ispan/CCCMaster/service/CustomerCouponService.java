package com.ispan.CCCMaster.service;

import javax.servlet.http.HttpSession;

public interface CustomerCouponService {

	Boolean createCustomerCoupon(HttpSession session, String convertid);

}
