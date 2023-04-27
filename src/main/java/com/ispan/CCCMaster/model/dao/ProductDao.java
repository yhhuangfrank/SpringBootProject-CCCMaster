package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("From Product p WHERE p.active = true")
    Page<Product> findByAllIsActive(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name%")
    Page<Product> findByName(@Param(value = "name") String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name% AND p.active = true")
    Page<Product> findByNameIsActive(@Param(value = "name") String name, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:name% AND p.active = true AND p.category= :categoryId")
    Page<Product> findByNameAndCategoryIsActive(@Param(value = "name") String name,@Param(value = "categoryId") Integer categoryId, Pageable pageable);
}
