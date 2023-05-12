package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.service.AdvertiseService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    private final ProductService productService;

    public AdvertiseController(AdvertiseService advertiseService, ProductService productService) {
        this.advertiseService = advertiseService;
        this.productService = productService;
    }

    @GetMapping("/front/advertise/product")
    public String advertiseProductList(Module model) {
        return "advertise";
    }

}
