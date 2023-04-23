package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String createBidProduct(
            @RequestBody @Valid @ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            model.addAttribute("isErrorExist", true);
            model.addAttribute("errors", fieldErrors);
            return "/back/bid/product-create";
        }

        bidProductService.createBidProduct(bidProductRequest);

        return "redirect:/bidProducts";
    }

    @GetMapping("/bidProducts")
    public String getAllBidProducts(Model model) {

        List<BidProduct> bidProducts = bidProductService.findAllBidProducts();

        model.addAttribute("bidProducts", bidProducts);

        return "/back/bid/products";
    }

    @GetMapping("/bidProducts/{id}/edit")
    public String getEditBidProductForm(@PathVariable Integer id, Model model) {

        // 查詢商品
        BidProduct foundBidProduct = bidProductService.findBidProductById(id);

        BidProductRequest bidProductRequest = new BidProductRequest();
        bidProductRequest.setName(foundBidProduct.getName());
        bidProductRequest.setBasePrice(foundBidProduct.getBasePrice());
        bidProductRequest.setDescription(foundBidProduct.getDescription());
        bidProductRequest.setCategoryName(foundBidProduct.getCategory().getName());

        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bidProductRequest", bidProductRequest);
        model.addAttribute("id", id);

        return "/back/bid/product-edit";
    }

    @PostMapping("/bidProducts/{id}")
    public String editBidProduct(@PathVariable Integer id,
                                 @RequestBody @Valid @ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest,
                                 BindingResult bindingResult,
                                 Model model) {

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            model.addAttribute("isErrorExist", true);
            model.addAttribute("errors", fieldErrors);

            return "/back/bid/product-edit";
        }

        bidProductService.updateBidProduct(id, bidProductRequest);

        return "redirect:/bidProducts";
    }
}
