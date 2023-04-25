package com.ispan.CCCMaster.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.ShoppingCartBean;
import com.ispan.CCCMaster.model.bean.ShoppingCartDetailBean;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDetailDao;

@Service
public class ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao scDao;
	
	@Autowired
	private ShoppingCartDetailDao scdDao;
	
	//購物車建立
	public void createShoppingCart(ShoppingCartBean sc) {
		Date date = new Date();
		String dateString = String.valueOf(date.getTime());
		sc.setShoppoingCartId(dateString);
		sc.setIsCheckout(0);
		scDao.save(sc);
	}
	//購物車明細建立
	public void createShoppingCartDetail(ShoppingCartDetailBean scd) {
		
		scdDao.save(scd);
	}

}
