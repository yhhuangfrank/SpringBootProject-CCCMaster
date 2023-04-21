package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.weihsiang.Product;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProductController {
@Autowired
    private ProductService pService;
    @GetMapping("/Products/createform")//新增產品表單
    public String getCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "back/Product-create";
    }
    @PostMapping("/Products/create")//新增產品表單送出
    public String createProduct(@ModelAttribute("product") Product product)  {
        try {
            product.setImage(product.getImageFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pService.createProduct(product);
       return "redirect:/Products/showAllProduct";
    }
    @GetMapping("/Products/showAllProduct")//產品列表
    public String showAllProduct(@RequestParam(name="p",defaultValue = "1") Integer pageNumber,Model model){
    Page<Product> page=pService.findByPage(pageNumber);
    model.addAttribute("page",page);
        return "back/showProduct";
    }
    @GetMapping(value = "Products/showImage/{productId}")//顯示產品的圖片
    public ResponseEntity<byte[]> getImage(@PathVariable("productId") Integer productId) {
        byte[] image = pService.getProductImageById(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @DeleteMapping("/Products/delete")
    public String deleteProductById(@RequestParam("id") Integer productId){
        pService.deleteProduct(productId);
        return "redirect:/Products/showAllProduct";
    }
}

