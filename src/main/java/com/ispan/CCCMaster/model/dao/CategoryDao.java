package com.ispan.CCCMaster.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ispan.CCCMaster.model.bean.category.Category;


public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query("FROM Category c WHERE c.name = :name")
    Category findCategoryByName(@Param(value = "name") String name);

}
