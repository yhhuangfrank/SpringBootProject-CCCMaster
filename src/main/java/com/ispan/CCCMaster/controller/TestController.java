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

        String a = "無效的輸入";
        String result = "";
        for (int i = 0; i < a.length() ;i += 1) {
            int c = a.charAt(i);
            String hexString = "\\u" + Integer.toHexString(c);
            result +=  hexString;
        }
        System.out.println(result);
        return "back/back-test";
    }
}
