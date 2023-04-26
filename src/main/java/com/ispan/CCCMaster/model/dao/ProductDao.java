package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductDao extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    Page<Product> findByName(@Param(value = "name")String name, Pageable pageable);
}
