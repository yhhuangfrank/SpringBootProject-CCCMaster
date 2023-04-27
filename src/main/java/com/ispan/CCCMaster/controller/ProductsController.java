package com.ispan.CCCMaster.controller;


import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.service.CrawlerService;
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


    @GetMapping("/front/product/details/{id}")
    public String productDetails(@PathVariable("id") Integer id, Model model) {
        pService.productViews(id);

        model.addAttribute("product", pService.findProductById(id));
        return "front/product/details";
    }


    //------------------------Ajax--------------------------------------
    @ResponseBody
    @GetMapping("/front/product/list")
    public Map<String, Object> searchProductNameApi(@RequestParam(name = "keyword", required = false) String keyword,
                                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNum,
                                                    @RequestParam(name = "sort", defaultValue = "default") String sort,
                                                    @RequestParam(name = "category", defaultValue = "all") String category)
    {
        System.out.println(sort);
        System.out.println(category);
        Page<Product> products;
        Map<String, Object> response = new HashMap<>();
        System.out.println("enter searchProductNameApi");
        System.out.println(pageNum);
        System.out.println(keyword);
        products = pService.findByPageAjax(pageNum, keyword, sort,category);
        response.put("categoryList",categoryService.findAllCategories());
        response.put("pageNum", pageNum);
        response.put("keyword", keyword);
        response.put("products", products);

        return response;
    }

    @GetMapping("/front/product")
    public String defaultProductPage(Model model) {
        System.out.println("enter defaultProductPage");
        return "front/product/productAjaxTest";
    }
    //------------------------Ajax--------------------------------------
//    @GetMapping("/front/product/search")
//    public String productSearchByName(@RequestParam("productName") String keyword, @RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
//        if(keyword.equals(""))return "redirect:/front/product";
//        Page<Product> page = pService.findByPageSearchByNameSortByPrice(pageNumber, keyword);
//        model.addAttribute("page", page);
//        model.addAttribute("keyword",keyword);
//        return "front/product/product";
//    }
    //    @ResponseBody
//    @GetMapping("/front/product/all")
//    public Page<Product> showAllProductByPage(@RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum) {
//        Page<Product> page = pService.findByPageSortByPrice(pageNum);
//        return page;
//    }
//    @ResponseBody
//    @GetMapping({"/front/product/all","/front/product/all/{page}"})
//    public Page<Product> defaultProductPage(@PathVariable(name = "page",required = false) Integer pageNum, Model model) {
//        System.out.println("enter defaultProductPage");
//        if(pageNum==null)pageNum=1;
//        Page<Product> page = pService.findByPageSortByPrice(pageNum);
//
//        return page;
//    }
}
