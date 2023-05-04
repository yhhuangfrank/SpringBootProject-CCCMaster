package com.ispan.CCCMaster.service;

import com.ispan.CCCMaster.model.bean.category.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();

}
