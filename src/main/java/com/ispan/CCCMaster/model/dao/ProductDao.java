package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDao extends JpaRepository<Product,Integer> {
}
