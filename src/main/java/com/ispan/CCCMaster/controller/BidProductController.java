package com.ispan.CCCMaster.controller;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.model.bean.bid.DealRecord;
import com.ispan.CCCMaster.model.bean.category.Category;
import com.ispan.CCCMaster.model.dto.BidProductRequest;
import com.ispan.CCCMaster.service.BidProductService;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.service.DealRecordService;
import com.ispan.CCCMaster.util.BidProductValidator;
import com.ispan.CCCMaster.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BidProductController {

    private final BidProductService bidProductService;

    private final CategoryService categoryService;

    private final DealRecordService dealRecordService;

    private final BidProductValidator bidProductValidator;

    private final LoginUtil loginUtil;

    public BidProductController(BidProductService bidProductService,
                                CategoryService categoryService,
                                DealRecordService dealRecordService,
                                BidProductValidator bidProductValidator,
                                LoginUtil loginUtil) {
        this.bidProductService = bidProductService;
        this.categoryService = categoryService;
        this.dealRecordService = dealRecordService;
        this.bidProductValidator = bidProductValidator;
        this.loginUtil = loginUtil;
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
            HttpSession session,
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

        // 新增商品
        Integer loginCustomerId = loginUtil.getLoginCustomerId(session).orElse(null);
        if (loginCustomerId == null)  return "redirect:/login";

        bidProductService.createBidProduct(loginCustomerId, bidProductRequest);

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
        DealRecord foundDealRecord = dealRecordService.findByBidProduct(foundBidProduct);

        // 查看人數加一
        foundBidProduct.setViewCount(foundBidProduct.getViewCount() + 1);
        bidProductService.updateBidProduct(foundBidProduct);

        model.addAttribute("bidProduct", foundBidProduct);
        model.addAttribute("dealRecord", foundDealRecord);

        return "/front/bid/product";
    }

    @GetMapping("/bidProducts/{id}/edit")
    public String getEditBidProductForm(HttpSession session,
                                        @PathVariable Integer id,
                                        Model model,
                                        RedirectAttributes redirectAttributes) {

        Integer loginCustomerId = loginUtil.getLoginCustomerId(session).orElse(null);
        if (loginCustomerId == null)  return "redirect:/login";

        // 查詢商品，商品擁有者才可編輯
        BidProduct foundBidProduct = bidProductService.findBidProductById(id);
        if (!bidProductService.checkIsOwner(id, loginCustomerId)) {
            redirectAttributes.addFlashAttribute("isWarning", true);
            redirectAttributes.addFlashAttribute("warningMsg", "不可編輯不是自己的商品！");
            return "redirect:/bidProducts";
        }

        BidProductRequest bidProductRequest = new BidProductRequest();
        bidProductRequest.setName(foundBidProduct.getName());
        bidProductRequest.setBasePrice(foundBidProduct.getBasePrice());
        bidProductRequest.setDescription(foundBidProduct.getDescription());
        bidProductRequest.setCategoryName(foundBidProduct.getCategory().getName());

        if (foundBidProduct.getExpiredAt() != null) {
            bidProductRequest.setEndDate(foundBidProduct.getExpiredAt().toString());
        }

        List<Category> categories = categoryService.findAllCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("bidProductRequest", bidProductRequest);
        model.addAttribute("id", id);

        return "/front/bid/product-edit";
    }

    @PostMapping("/bidProducts/{id}")
    public String editBidProduct(HttpSession session,
                                 @PathVariable Integer id,
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

        // 更新商品資訊，商品擁有者才可編輯
        Integer loginCustomerId = loginUtil.getLoginCustomerId(session).orElse(null);
        if (loginCustomerId == null)  return "redirect:/login";

        if (!bidProductService.checkIsOwner(id, loginCustomerId)) {
            redirectAttributes.addFlashAttribute("isWarning", true);
            redirectAttributes.addFlashAttribute("warningMsg", "不可編輯不是自己的商品！");
            return "redirect:/bidProducts";
        }

        bidProductService.updateBidProduct(id, bidProductRequest);

        redirectAttributes.addFlashAttribute("isSuccess", true);
        redirectAttributes.addFlashAttribute("successMsg", "修改成功!");

        return "redirect:/bidProducts/{id}";
    }
}
