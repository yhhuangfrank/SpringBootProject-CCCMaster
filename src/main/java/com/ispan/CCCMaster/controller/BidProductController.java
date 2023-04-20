package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BidProductController {

    @Autowired
    private BidProductService bidProductService;

    @GetMapping("/bidProducts/create")
    public String getCreateBidProductForm(Model model) {

        model.addAttribute("bidProductRequest", new BidProductRequest());

        return "/back/bid/product-create";
    }

    @PostMapping("/bidProducts")
    public String createBidProduct(@ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest) {



        return "/back/bid/product-create";
    }
}
