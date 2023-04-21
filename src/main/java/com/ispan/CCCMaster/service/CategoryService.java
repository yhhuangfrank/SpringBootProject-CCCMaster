package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.bid.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();

    List<Category> findCategoryByName(String name);
}
