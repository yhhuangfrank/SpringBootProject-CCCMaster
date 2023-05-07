package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.coupon.CouponBean;
import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.customer.CustomerCoupon;
import com.ispan.CCCMaster.model.bean.order.OrderDetailBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartDetailBean;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDetailDao;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao scDao;
	
	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private ShoppingCartDetailDao scdDao;
	
	//購物車建立
	@Override
	public void createShoppingCart(ShoppingCartBean sc,Integer productId,Integer customerId) {
		//取ShoppingCartID
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());		
		if(scDao.findByCid(customerId) == null) {
			sc.setShoppoingCartId(dateString);
			//取產品ID&加入訂單明細
			Optional<Product> pOption= pDao.findById(productId);
			Product p = pOption.get();
			Set<ShoppingCartDetailBean> scdBean = new HashSet<>();
			ShoppingCartDetailBean scd = new ShoppingCartDetailBean();
			Set<ShoppingCartDetailBean> list = sc.getSetscd();
				scd.setUnitprice(p.getPrice());
				scd.setProductBean(p);
				scd.setShoppingCartBean(sc);
				scdBean.add(scd);
				sc.setSetscd(scdBean);
				scDao.save(sc);
		}else {
			sc.setShoppoingCartId(scDao.findByCid(customerId));
			//取產品ID&只增加訂單明細
			Optional<Product> pOption= pDao.findById(productId);
			Product p = pOption.get();
			ShoppingCartDetailBean scd = new ShoppingCartDetailBean();
				scd.setUnitprice(p.getPrice());
				scd.setProductBean(p);
				scd.setShoppingCartBean(sc);
				scdDao.save(scd);
		}					
	}
	//查詢購物車
//	@Override
//	public List<ShoppingCartBean> findShoppingCartByCid(Integer customerId) {
//		List<ShoppingCartBean> list = scDao.findByCid(customerId);
//		 return list;
//	}

	@Override
	public List<ShoppingCartBean> findAll(){
		return scDao.findAll();
	}
	
	//刪除購物車
	@Override
	public void deleteBySCId(String shoppoingCartId) {
		scDao.deleteById(shoppoingCartId);
	}
	
	//修改購物車
	@Override
	@Transactional
	public void editBySCId(ShoppingCartBean sc) throws IOException{
		Optional<ShoppingCartBean> option = scDao.findById(sc.getShoppoingCartId());
		if(option.isPresent()) {
			ShoppingCartBean scb = option.get();
			scb.setShipper(sc.getShipper());
			scb.setShipperaddress(sc.getShipperaddress());
//			scb.setQuantity();
			scb.setScpayment(sc.getScpayment());
			scb.setAddressee(sc.getAddressee());
			scb.setTelephone(sc.getTelephone());
		}
	}

	@Override
	public void editAll(List<ShoppingCartBean> sc) throws IOException {
		scDao.saveAll(sc);
		
	}


	//刪除購物車
	@Override
	public void deleteAll() {
		scDao.deleteAll();
	}

//	//依照cid刪除各自的購物車
//	@Override
//	public void deletescByCId(Integer id) {
//		scDao.deleteByCid(id);		
//	}



}
