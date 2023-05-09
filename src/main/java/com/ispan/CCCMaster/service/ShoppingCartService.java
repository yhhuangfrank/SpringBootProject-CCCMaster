package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import com.ispan.CCCMaster.model.bean.customer.Customer;

import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface ShoppingCartService {


	//購物車建立
	void createShoppingCart(ShoppingCartBean sc,Integer customerId,Integer productId);
	

	//刪除購物車
	void deleteBySCId(String shoppoingCartId);

	//查詢購物車
	List<ShoppingCartBean> findByCid(Integer customerId);

	//修改購物車購買數量
	void editBySCId(ShoppingCartBean sc) throws IOException;
	
	
	//刪除所有購物車
	void deletescByCId(Integer customerId);
	
}