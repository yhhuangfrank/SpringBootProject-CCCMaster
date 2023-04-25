package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dao.CategoryDao;
import com.ispan.CCCMaster.service.BidProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private BidProductService bidProductService;

    @GetMapping("/")
    public String home() {
        return "back/back-test";
    }

    @GetMapping("/test")
    public String test() {
        bidProductService.findBidProductById(100);


        return "back/back-test";
    }
}
