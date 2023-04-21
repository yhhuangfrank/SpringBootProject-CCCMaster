package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Forum;
import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.Normalizer;

@Controller
public class ProductController {
@Autowired
    private ProductService pService;
    @GetMapping("/Products/createform")
    public String getCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "back/Product-create";
    }
    @PostMapping("/Products/create")
    public String createProduct(@ModelAttribute("product") Product product)  {
        try {
            product.setImage(product.getImageFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pService.createProduct(product);
       return "back/back-test";
    }
}

