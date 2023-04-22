package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class BidProductController {

    @Autowired
    private BidProductService bidProductService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/bidProducts/create")
    public String getCreateBidProductForm(Model model) {

        // 取得目前有的種類清單
        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bidProductRequest", new BidProductRequest());

        return "/back/bid/product-create";
    }

    @PostMapping("/bidProducts")
    public String createBidProduct(@RequestBody @ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest) {

        bidProductService.createBidProduct(bidProductRequest);

        return "redirect:/bidProducts";
    }

    @GetMapping("/bidProducts")
    public String getAllBidProducts(Model model) {

        List<BidProduct> bidProducts = bidProductService.findAllBidProducts();

        model.addAttribute("bidProducts", bidProducts);

        return "/back/bid/products";
    }
}
