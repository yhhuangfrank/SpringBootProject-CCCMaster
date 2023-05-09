package com.ispan.CCCMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.CCCMaster.service.ProductImageService;

@Controller
public class ProductImageController {
    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/product/mainImage/{productId}")//顯示產品的主要圖片，用於產品列表
    public ResponseEntity<byte[]> getMainImage(@PathVariable("productId") Integer productId) {
//        System.out.println("enter /product/mainImage/{productId}");
        return productImageService.showMainImage(productId);
    }

    @GetMapping("/product/showImage/{productImageId}")//透過圖片id顯示圖片，用於detail的跑馬燈
    public ResponseEntity<byte[]>getImage(@PathVariable("productImageId") Integer productImageId){
//        System.out.println("enter getImage");
        return productImageService.showImageByImageId(productImageId);

    }


    @ResponseBody
    @GetMapping("/product/images")//取得該產品的所有圖片id
    public List<Integer> getAllProductImageId(@RequestParam("productId") Integer productId) {
//        System.out.println("enter getAllProductImageId");
        return productImageService.getProductImagesList(productId);
    }
}
