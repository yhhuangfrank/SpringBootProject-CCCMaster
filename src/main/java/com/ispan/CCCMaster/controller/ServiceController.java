package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceController {

    @GetMapping("/Servic/console")
    public String home() {
        return "back/Service-console";
    }
}
