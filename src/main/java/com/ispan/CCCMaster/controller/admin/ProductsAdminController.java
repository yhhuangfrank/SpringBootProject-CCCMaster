package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductsAdminController {
    @Autowired
    private ProductService pService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/admin/products/create/form")//新增產品表單
    public String getCreateProductForm(Model model) {
        List<Category> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "back/product/createProduct";
    }

    @PostMapping("/admin/products/create")//新增產品表單送出
    public String createProduct(@ModelAttribute("product") Product product, @RequestParam("categoryName") String categoryName) {
        try {
            pService.createProduct(product, categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/admin/products/showAllProduct";
    }

    @GetMapping("/admin/products/showAllProduct")//產品列表
    public String showAllProduct(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
        Page<Product> page = pService.findByPage(pageNumber);
        model.addAttribute("page", page);
        return "back/product/showProduct";
    }





    @DeleteMapping("/admin/products/delete") //刪除產品
    public String deleteProductById(@RequestParam("id") Integer productId) {
        pService.deleteProduct(productId);
        return "redirect:/admin/products/showAllProduct";
    }

    @GetMapping("/admin/products/editForm") //編輯產品頁面
    public String editPage(@RequestParam("id") Integer productId, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("product", pService.findProductById(productId));
        return "back/product/editProductPage";
    }

    @PutMapping("/admin/products/edit")//更新產品
    public String editProductById(@ModelAttribute("product") Product product, @RequestParam("categoryName") String categoryName) {
        try {
            pService.editProductById(product, categoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/products/showAllProduct";
    }

}

