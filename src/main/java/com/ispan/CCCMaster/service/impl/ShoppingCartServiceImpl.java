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
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dao.CustomerDao;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao scDao;
	
	@Autowired
	private ProductDao pDao;
	
	@Autowired
	private  CustomerDao cDao;
	
	//購物車建立
	@Override
	public void createShoppingCart(ShoppingCartBean sc,Integer customerId,Integer productId) {
				//shoppingcart的customerid
				Optional<Customer> cOption = cDao.findById(customerId);
				Customer c = cOption.get();
				sc.setCbShoppingCart(c);
				//shoppingcartid
				Date date = new Date();
				String dateString = String.valueOf(date.getTime());
				sc.setShoppoingCartId(dateString);
				//shoppingcart的productid&price
				Optional<Product> pOption= pDao.findById(productId);			
				Product p = pOption.get();			
				sc.setUnitprice(p.getPrice());
				sc.setProductBean(p);
				sc.setScquantity(sc.getScquantity());
				scDao.save(sc);
			}
	//查詢購物車
	@Override
	public List<ShoppingCartBean> findByCid(Integer customerId) {
		return scDao.findAllByCid(customerId);
	}
	
	//刪除單項產品(購物車)
	@Override
	public void deleteBySCId(String shoppoingCartId) {
		scDao.deleteById(shoppoingCartId);
	}
	
	//修改購物車數量
	@Override
	@Transactional
	public void editBySCId(ShoppingCartBean sc) throws IOException{
		Optional<ShoppingCartBean> option = scDao.findById(sc.getShoppoingCartId());
		if(option.isPresent()) {
			ShoppingCartBean scb = option.get();
			scb.setScquantity(sc.getScquantity());
		}
	}
	

	//依照cid刪除各自的購物車
	@Override
	public void deletescByCId(Integer customerId) {
		scDao.deleteByCid(customerId);		
	}



}
