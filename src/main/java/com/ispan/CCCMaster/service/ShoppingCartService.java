package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import com.ispan.CCCMaster.model.bean.customer.Customer;

import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface ShoppingCartService {


	//購物車建立
	void createShoppingCart(ShoppingCartBean sc, Integer productId);

	List<ShoppingCartBean> findAll();

	//刪除購物車
	void deleteBySCId(String shoppoingCartId);


	List<ShoppingCartBean> findByCid(Customer c,ShoppingCartBean sc);

	//修改購物車購買數量
	void editBySCId(ShoppingCartBean sc) throws IOException;
	
	
	//刪除所有購物車
//	void deletescByCId(Integer id);
	
	//刪除購物車
	void deleteAll();
}