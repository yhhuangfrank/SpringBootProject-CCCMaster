package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dao.CategoryDao;
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
import java.util.Map;

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

//        System.out.println(bidProductRequest);
        List<Category> list = categoryService.findCategoryByName("電腦x");
        System.out.println(list.get(0));
        for (Category c : list) {
            System.out.println(c);
        }

        return "/back/bid/product-create";
    }
}
