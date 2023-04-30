package com.ispan.CCCMaster.controller.admin;

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
@RequestMapping("/admin")
public class BidProductAdminController {

    private final BidProductService bidProductService;

    private final CategoryService categoryService;

    private final BidProductValidator bidProductValidator;

    @Autowired
    public BidProductAdminController(BidProductService bidProductService,
                                     CategoryService categoryService,
                                     BidProductValidator bidProductValidator) {
        this.bidProductService = bidProductService;
        this.categoryService = categoryService;
        this.bidProductValidator = bidProductValidator;
    }

    @GetMapping("/bidProducts")
    public String getAllBidProducts(Model model) {

        List<BidProduct> bidProducts = bidProductService.findAllBidProducts();

        model.addAttribute("bidProducts", bidProducts);

        return "/back/bid/products";
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
