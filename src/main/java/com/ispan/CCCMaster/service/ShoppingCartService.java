package com.ispan.CCCMaster.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.Customer;
import com.ispan.CCCMaster.model.bean.ShoppingCartBean;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao scDao;
	
	@Autowired
	private ProductDao pDao;
	
	
	//購物車建立
	public void createShoppingCart(ShoppingCartBean sc,Integer productId) {
		Optional<Product> pOption= pDao.findById(productId);
		Product p = pOption.get();
		sc.setProductBean(p);
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());
		sc.setShoppoingCartId(dateString);
//		scDao.addCIdToSC(sc.getCbShoppingCart().getId());
		scDao.save(sc);
	}
	//查詢購物車
//	public List<ShoppingCartBean> findShoppingCartByCid(Customers c) {
//		List<ShoppingCartBean> list = scDao.findByCid(c);
//		 return list;
//	}

	public List<ShoppingCartBean> findtest(){
		return scDao.findAll();
	}
	
	

}
