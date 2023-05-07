package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ispan.CCCMaster.model.bean.shoppingcart.ShoppingCartDetailBean;

public interface ShoppingCartDetailDao extends JpaRepository<ShoppingCartDetailBean, Integer>{

}
