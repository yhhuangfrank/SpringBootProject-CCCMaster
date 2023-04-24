package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/")
    public String home() {
        return "back/back-test";
    }

    @GetMapping("/test")
    public String test() {

        Category category = categoryDao.findCategoryByName("手機");
        System.out.println(category);
        return "back/back-test";
    }
    @GetMapping("/front/test")
    public String frontTest(){
        return "front/frontExample";
    }
}
