package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;
import com.ispan.CCCMaster.model.dao.CouponDao;
import com.ispan.CCCMaster.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CouponDao cpDao;
	
	//創造優惠券
	@Override
	public void createCoupon(CouponBean couponBean) {
		UUID uuid = UUID.randomUUID();
		String uuidString  = uuid.toString().replace("-", "").substring(0,20);
		couponBean.setCouponid(uuidString);
		cpDao.save(couponBean);
	}
	
	
	//查詢所有優惠券
//	public List<CouponBean> findCoupons() throws ParseException{
//		List<CouponBean> list = cpDao.findAllCoupons();
//		List<Map<String,Object>> listm = new ArrayList<>();
//		for(CouponBean cpb : list) {
//			Map<String,Object> map = new HashMap<>();
//			map.put("couponid", cpb.getCouponid());
//			map.put("couponname", cpb.getCouponname());
//			map.put("convertid", cpb.getConvertid());
//			String sDate = changeSD(cpb);
//			map.put("startdate", sDate);
//			String eDate = changeED(cpb);
//			map.put("enddate", eDate);
//			map.put("couponamount", cpb.getCouponamount());
//			map.put("instructions", cpb.getInstructions());
//			listm.add(map);
//		}
//		return cpDao.findAllCoupons();
//	}
	
	//查詢單張優惠券
	@Override
	public CouponBean findCouponById(String couponid) {
		Optional<CouponBean> option = cpDao.findById(couponid);
		if(option.isEmpty()) {
			return null;
		}
		return option.get();
	}
	
	//刪除優惠券
	@Override
	public void deleteCoupon(String couponid) {
		cpDao.deleteById(couponid);
	}
	
	//更新優惠券
	@Override
	@Transactional
	public void updateCouponById(CouponBean couponBean) throws IOException{
		Optional<CouponBean> option = cpDao.findById(couponBean.getCouponid());		
		if(option.isPresent()) {
			CouponBean oldCoupon = option.get();
			oldCoupon.setCouponname(couponBean.getCouponname());
			oldCoupon.setConvertid(couponBean.getConvertid());
			oldCoupon.setCouponamount(couponBean.getCouponamount());
			oldCoupon.setStartdate(couponBean.getStartdate());
			oldCoupon.setEnddate(couponBean.getEnddate());
			oldCoupon.setInstructions(couponBean.getInstructions());
		}
	}
	//更改時間格式:-字串->date->字串
	@Override
	public String changeSD(CouponBean cb) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date sDate = formatter.parse(cb.getStartdate());		
		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String ssDate = dateformatter.format(sDate);
		return ssDate;
	}
	//更改時間格式:-字串->date->字串
	@Override
	public String changeED(CouponBean cb) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date eDate = formatter.parse(cb.getEnddate());
		SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String eeDate = dateformatter.format(eDate);
		return eeDate;
	}
	//頁數
	@Override
	public Page<CouponBean> findByPage(Integer pageNumber){
		Pageable pg = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC,"couponname");
		Page<CouponBean> page = cpDao.findAll(pg);
		
		return page;
	}

}
