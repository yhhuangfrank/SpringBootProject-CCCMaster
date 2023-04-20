package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.dto.BidProductRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BidProductController {

    @GetMapping("/bidProducts/create")
    public String getCreateBidProductForm(Model model) {

        model.addAttribute("bidProductRequest", new BidProductRequest());

        return "/back/bid/product-create";
    }

    @PostMapping("/bidProducts")
    public String createBidProduct(@ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest) {

        System.out.println(bidProductRequest);

        return "/back/bid/product-create";
    }
}
