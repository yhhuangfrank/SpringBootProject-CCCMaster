package com.ispan.CCCMaster.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartBean;
import com.ispan.CCCMaster.model.dao.ProductDao;
import com.ispan.CCCMaster.model.dao.ShoppingCartDao;
import com.ispan.CCCMaster.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	@Autowired
	private ShoppingCartDao scDao;
	
	@Autowired
	private ProductDao pDao;
	
	
	//購物車建立
	@Override
	public void createShoppingCart(ShoppingCartBean sc,Integer productId) {
		//取產品ID
		Optional<Product> pOption= pDao.findById(productId);
		Product p = pOption.get();
		sc.setProductBean(p);
		sc.setUnitprice(p.getPrice());
		//取ShoppingCartID
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
			scb.setQuantity(sc.getQuantity());
		}
	}

	@Override
	public void editAll(List<ShoppingCartBean> sc) throws IOException {
		scDao.saveAll(sc);
		
	}

	@Override
	public List<ShoppingCartBean> findByCid(Customer c, ShoppingCartBean sc) {
		return scDao.findByCid(sc.getCbShoppingCart().getCustomerId());
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
