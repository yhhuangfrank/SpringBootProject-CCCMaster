package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminHomeController {

    // 後台
    @GetMapping("/admin")
    public String adminHome() {
        return "back/adminHome";
    }

}
