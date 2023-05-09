package com.ispan.CCCMaster.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

}
