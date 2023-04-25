package com.ispan.CCCMaster.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.CouponBean;
import com.ispan.CCCMaster.service.CouponService;

@Controller
public class CouponController {
	
	@Autowired
	CouponService cpService;
	
	//空白的優惠券表單
	@GetMapping("/Coupons/CreateForm")
	public String createCouponForm(Model model) {
		model.addAttribute("coupon",new CouponBean());
		return "back/coupon/Coupon-create";
	}
	
	//新增優惠券
	@PostMapping("/Coupons/Create")
	public String createCoupon(@ModelAttribute("CouponBean") CouponBean couponBean) {
		cpService.createCoupon(couponBean);
		return "redirect:/Coupons";
	}
	//查詢所有優惠券
	@GetMapping("/Coupons")
	public String findAllCoupon(@RequestParam(name="p",defaultValue = "1") Integer pageNumber,Model model) throws ParseException {
		Page<CouponBean> page = cpService.findByPage(pageNumber);
		model.addAttribute("page",page);
		return "/back/coupon/showCoupons";
	}
	
	//查詢單張優惠券
	@GetMapping("/Coupons/editCoupon")
	public String findCouponById(@RequestParam("id") String couponid,Model model) throws ParseException {
		CouponBean cpb =  cpService.findCouponById(couponid);
		model.addAttribute("coupon",cpb);
		return "/back/coupon/Coupon-edit";
	}
	//修改優惠券
	@PutMapping("/Coupons/edit")
	public String editCouponById(@ModelAttribute("coupon") CouponBean couponBean) {
		try {
			cpService.updateCouponById(couponBean);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/Coupons";
	}
	//刪除優惠券
	@DeleteMapping("/Coupons/delete")
	public String deleteCouponById(@RequestParam("id") String couponid) {
		cpService.deleteCoupon(couponid);
		return "redirect:/Coupons";
	}
	

}
