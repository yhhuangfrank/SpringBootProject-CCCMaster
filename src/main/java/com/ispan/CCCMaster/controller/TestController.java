package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String home() {
        return "front/frontExample";
    }
}
