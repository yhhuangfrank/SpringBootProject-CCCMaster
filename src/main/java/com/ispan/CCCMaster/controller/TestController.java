package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.CCCMaster.service.BidProductService;

@Controller
public class TestController {

    @Autowired
    private BidProductService bidProductService;

    // 前台
    @GetMapping("/")
    public String home() {
        return "front/frontExample";
    }

    // 後台
    @GetMapping("/admin")
    public String adminHome() {
        return "back/back-test";
    }

    // 測試用
    @GetMapping("/test")
    public String test() {


        return "back/back-test";
    }
    @GetMapping("/front/test")
    public String frontTest(){
        return "front/frontExample";
    }
}
