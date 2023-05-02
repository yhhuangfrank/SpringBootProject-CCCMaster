package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@Controller
public class ProductsController {
    @Autowired
    private ProductService pService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/front/product/details/{id}")//商品列表跳轉到商品細節頁面
    public String productDetails(@PathVariable("id") Integer id, Model model) {
        pService.productViews(id);
        model.addAttribute("product", pService.findProductById(id));
        return "front/product/details";
    }




    @ResponseBody
    @GetMapping("/front/product/list")//商品列表多條件搜尋
    public Map<String, Object> searchProductNameApi(@RequestParam(name = "keyword", required = false) String keyword,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(name = "sort", defaultValue = "productId_asc") String sort,
                                                    @RequestParam(name = "category") String category) {
//        System.out.println(category);
        Page<Product> products;
        Map<String, Object> response = new HashMap<>();
        products = pService.findByCriteria(pageNum, keyword, sort, category);
        response.put("categoryList", categoryService.findAllCategories());
        response.put("pageNum", pageNum);
        response.put("keyword", keyword);
        response.put("products", products);

        return response;
    }

    @GetMapping("/front/product") //topbar跳轉到商品列表
    public String defaultProductPage(Model model) {
//        System.out.println("enter defaultProductPage");
        return "front/product/productAjaxTest";
    }


    //------------------------Ajax--------------------------------------

}
