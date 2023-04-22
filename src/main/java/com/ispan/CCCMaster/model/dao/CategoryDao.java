package com.ispan.CCCMaster.model.dao;

import com.ispan.CCCMaster.model.bean.bid.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    @Query("FROM Category c WHERE c.name = :name")
    List<Category> findCategoryByName(@Param(value = "name") String name);

    @Query("FROM Category c WHERE c.name = :name")
    Category findCategoryByNameReturnCategory(@Param(value = "name") String name);
}
