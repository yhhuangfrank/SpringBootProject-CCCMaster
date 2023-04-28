package com.ispan.CCCMaster.service;

import java.io.IOException;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;

public interface ShoppingCartService {

	//購物車建立
	void createShoppingCart(ShoppingCartBean sc, Integer productId);

	List<ShoppingCartBean> findtest();

	//刪除購物車
	void deleteBySCId(String shoppoingCartId);

	//修改購物車
	void editBySCId(ShoppingCartBean sc) throws IOException;

}