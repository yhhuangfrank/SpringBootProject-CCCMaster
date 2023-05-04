package com.ispan.CCCMaster.util;

import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class GenDefaultCategory {

    @Autowired
    private CategoryDao categoryDao;

    private List<Category> defaultCategories = new ArrayList<>();

    @PostConstruct // 新建 bean 時，檢查 Category 資料表是否有預設值
    public void genDefaultCategories() {

        long num = categoryDao.count();
        if (num > 0) return;

        String[] defaultCategoryNames = new String[]{"手機", "滑鼠", "鍵盤", "電腦", "筆記型電腦"};

        for (String name : defaultCategoryNames) {
            Category category = new Category();
            category.setName(name);
            category.setCreatedAt(new Date());
            defaultCategories.add(category);
        }

        categoryDao.saveAll(defaultCategories);

    }

}
