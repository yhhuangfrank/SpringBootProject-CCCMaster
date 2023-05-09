package com.ispan.CCCMaster.service;

import java.util.List;

import com.ispan.CCCMaster.model.bean.category.Category;

public interface CategoryService {

    List<Category> findAllCategories();

}
