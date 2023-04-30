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

	//修改購物車
	void editAll(List<ShoppingCartBean> sc) throws IOException;

	List<ShoppingCartBean> findByCid(Customer c,ShoppingCartBean sc);

	void editBySCId(ShoppingCartBean sc) throws IOException;
}