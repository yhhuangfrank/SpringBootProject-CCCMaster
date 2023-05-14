package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.service.AdvertiseService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class AdvertiseController {

    private final AdvertiseService advertiseService;

    private final ProductService productService;

    public AdvertiseController(AdvertiseService advertiseService, ProductService productService) {
        this.advertiseService = advertiseService;
        this.productService = productService;
    }

    @GetMapping("/front/frontExample")
    public String advertiseByTime(Model model) {


        List<Integer> productImageIds = getAllProductImageId();


        model.addAttribute("productImageIds", productImageIds);
        return "front/advertise/advertise";
    }

    @ResponseBody
    @GetMapping("/advertise/product/images/")//取得該產品的所有圖片id
    public List<Integer> getAllProductImageId() {
        Date now = new Date();
        List<Advertise> advertises = advertiseService.advertiseByTime(now);
        if (advertises.size() > 0) {
            Advertise advertise = advertises.get(0);
            Set<Product> products = advertise.getProducts();


            //取得產品圖片id，回傳產品圖片id
            return products.stream().map(product -> product.getProductId()).collect(Collectors.toList());
        }

//        <img style="width: 50px; "
//        src="${contextRoot}/product/mainImage/${product.productId}"/>
        return Collections.emptyList();
    }

}

