package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BidProductController {

    @GetMapping("/bidProducts/create")
    public String getCreateBidProductForm() {
        return "back/bidProduct-create";
    }
}
