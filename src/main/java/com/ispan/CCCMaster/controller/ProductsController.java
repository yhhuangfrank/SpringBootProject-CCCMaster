package com.ispan.CCCMaster.controller;

import com.fasterxml.jackson.core.JsonToken;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class ProductsController {
    @Autowired
    private ProductService pService;

    @GetMapping("/front/product")
    public String defaultProductPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Product> page = pService.findByPageSortByPrice(pageNumber);
        model.addAttribute("page", page);
        return "front/product/product";
    }

    @GetMapping("/fornt/product/details/{id}")
    public String productDetails(@PathVariable("id") Integer id, Model model) {
        pService.productViews(id);
        model.addAttribute("product", pService.findProductById(id));
        return "front/product/details";
    }

    @GetMapping("/front/product/search")
    public String productSearchByName(@RequestParam("productName") String productName, @RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        System.out.println(productName);
        Page<Product> page = pService.findByPageSearchByNameSortByPrice(pageNumber,productName);
        model.addAttribute("page", page);
        return "front/product/product";
    }

}
