package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.Category;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.util.BidProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BidProductController {

    private final BidProductService bidProductService;

    private final CategoryService categoryService;

    private final BidProductValidator bidProductValidator;

    @Autowired
    public BidProductController(BidProductService bidProductService,
                                CategoryService categoryService,
                                BidProductValidator bidProductValidator) {
        this.bidProductService = bidProductService;
        this.categoryService = categoryService;
        this.bidProductValidator = bidProductValidator;
    }

    @GetMapping("/bidProducts/create")
    public String getCreateBidProductForm(Model model) {

        // 取得目前有的種類清單
        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bidProductRequest", new BidProductRequest());

        return "/front/bid/product-create";
    }

    @PostMapping("/bidProducts")
    public String createBidProduct(
            @RequestBody @Valid @ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        // 驗證表單
        bidProductValidator.validate(bidProductRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            model.addAttribute("isErrorExist", true);
            model.addAttribute("errors", fieldErrors);
            List<Category> categories = categoryService.findAllCategories();
            model.addAttribute("categories", categories);
            return "front/bid/product-create";
        }

        bidProductService.createBidProduct(bidProductRequest);

        redirectAttributes.addFlashAttribute("isSuccess", true);
        redirectAttributes.addFlashAttribute("successMsg", "新增成功!");

        return "redirect:/bidProducts";
    }

    @GetMapping("/bidProducts")
    public String getAllBidProducts() {
        return "/front/bid/products";
    }

    @GetMapping("/bidProducts/{id}")
    public String getBidProduct(@PathVariable Integer id,
                                Model model) {

        BidProduct foundBidProduct = bidProductService.findBidProductById(id);

        model.addAttribute("bidProduct", foundBidProduct);

        return "/front/bid/product";
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
        bidProductRequest.setEndDate(foundBidProduct.getExpiredAt().toString());

        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bidProductRequest", bidProductRequest);
        model.addAttribute("id", id);

        return "/front/bid/product-edit";
    }

    @PostMapping("/bidProducts/{id}")
    public String editBidProduct(@PathVariable Integer id,
                                 @RequestBody @Valid @ModelAttribute("bidProductRequest") BidProductRequest bidProductRequest,
                                 BindingResult bindingResult,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {

        bidProductValidator.validate(bidProductRequest, bindingResult);

        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            model.addAttribute("isErrorExist", true);
            model.addAttribute("errors", fieldErrors);

            return "/front/bid/product-edit";
        }

        bidProductService.updateBidProduct(id, bidProductRequest);

        redirectAttributes.addFlashAttribute("isSuccess", true);
        redirectAttributes.addFlashAttribute("successMsg", "修改成功!");

        return "redirect:/bidProducts/{id}";
    }

    @DeleteMapping("/bidProducts/{id}")
    public String deleteBidProduct(@PathVariable Integer id,
                                  RedirectAttributes redirectAttributes) {

        bidProductService.deleteBidProduct(id);

        redirectAttributes.addFlashAttribute("isSuccess", true);
        redirectAttributes.addFlashAttribute("successMsg", "刪除成功!");

        return "redirect:/admin/bidProducts";
    }
}
