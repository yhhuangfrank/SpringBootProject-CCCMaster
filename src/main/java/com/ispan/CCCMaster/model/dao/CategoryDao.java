package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query("FROM Category c WHERE c.name = :name")
    Category findCategoryByName(@Param(value = "name") String name);

}
