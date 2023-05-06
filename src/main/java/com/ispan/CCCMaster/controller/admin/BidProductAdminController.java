package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.bid.BidProduct;
import com.ispan.CCCMaster.service.BidProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class BidProductAdminController {

    private final BidProductService bidProductService;

    public BidProductAdminController(BidProductService bidProductService) {
        this.bidProductService = bidProductService;
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
