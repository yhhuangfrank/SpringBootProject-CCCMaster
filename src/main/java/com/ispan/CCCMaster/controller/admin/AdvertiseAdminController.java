package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.bean.product.Product;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import com.ispan.CCCMaster.service.CategoryService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AdvertiseAdminController {



    private final AdvertiseService advertiseService;

    private final ProductService productService;



    public AdvertiseAdminController(AdvertiseService advertiseService, ProductService productService) {

        this.advertiseService = advertiseService;

        this.productService = productService;
    }


    @GetMapping("/admin/advertises/createform")
    public String addAdvertise(Model model) {
        model.addAttribute("advertiseRequest", new AdvertiseRequest());

        return "back/advertise/advertise-create";
    }

    @PostMapping("/admin/advertises/create")
    public String createAdvertise(@ModelAttribute("advertiseRequest") AdvertiseRequest advertiseRequest,
                                  Model model){

        advertiseService.createAdvertise(advertiseRequest);
        return "redirect:/admin/advertises/showAllAdvertise";
    }

    @GetMapping("/admin/advertises/showAllAdvertise")
    public String showAllAdvertise(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber,Model model) {
        Page<Advertise> page = advertiseService.findByPage(pageNumber);
        model.addAttribute("page",page);
        Advertise startTime = advertiseService.getLatestAdvertise();
        model.addAttribute("startTime",startTime);
        return "back/advertise/showAdvertise";
    }
//    @GetMapping("/admin/advertises/editPage")
//    public String updateAdvertiseById(@RequestParam("id") Integer advertiseId, Model model) {
//        Advertise advertiseById = advertiseService.findAdvertiseById(advertiseId);
//
//        model.addAttribute("advertise", advertiseById);
//        return "back/advertise/editAdvertise";
//    }
//
//    @PutMapping("/admin/advertises/edit")
//    public String putEditedAdvertise(@ModelAttribute("advertise") Advertise advertise ) {
//        advertiseService.updateAdvertiseById(advertise);
//        return "redirect:/admin/advertises/showAllAdvertise";
//    }

    @GetMapping("/admin/advertises/editPage/{id}")
    public String updateAdvertise(HttpSession session,
                                  @PathVariable Integer id,
                                  Model model,
                                  RedirectAttributes redirectAttributes){
        Advertise foundadvertise = advertiseService.findAdvertiseById(id);

        AdvertiseRequest advertiseRequest = new AdvertiseRequest();

        if(foundadvertise.getStartTime()!=null){
            advertiseRequest.setStartDateTime(foundadvertise.getStartTime().toString());
        }
        if(foundadvertise.getEndTime()!=null){
            advertiseRequest.setEndDateTime(foundadvertise.getEndTime().toString());
        }

        model.addAttribute("advertiseRequest",advertiseRequest);
        model.addAttribute("id",id);
        return "/back/advertise/editAdvertise";
    }

    @PutMapping("/admin/advertises/edit/{id}")
    public String updateAdvertise(HttpSession session,
                                  @PathVariable Integer id,
                                  @Valid @ModelAttribute("advertiseRequest") AdvertiseRequest advertiseRequest,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {
        advertiseService.updateAdvertiseById(id,advertiseRequest);
        return "redirect:/admin/advertises/showAllAdvertise";

    }

    @DeleteMapping("/admin/advertises/delete")
    public String deleteAdvertiseById(@RequestParam("id") Integer id) {
        advertiseService.deleteAdvertiseById(id);
        return "redirect:/admin/advertises/showAllAdvertise";
    }


    @GetMapping("/admin/advertises/addProductToAdvertise")
    public String addProductToAdvertise(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                        @RequestParam("advertiseId") Integer advertiseId,
                                        @RequestParam("productId") Integer productId,
                                        Model model){
            Page<Product> page = productService.findByPage(pageNumber);
            Product product = productService.findProductById(productId);
            Advertise advertise = advertiseService.findAdvertiseById(advertiseId);
            advertise.getProducts().add(product);
            advertiseService.updateAdvertiseById(advertise);

            model.addAttribute("page", page);
        return "redirect:/admin/advertises/showProduct?p="+pageNumber+"&advertiseId="+advertiseId;
    }

    @GetMapping("/admin/advertises/showProduct")
    public String addProductToAdvertise(@RequestParam(name = "p",defaultValue = "1") Integer pageNumber,
                                        @RequestParam("advertiseId") Integer advertiseId,
                                        Model model){

        Page<Product> page = productService.findByPage(pageNumber);
        model.addAttribute("advertiseId",advertiseId);

        model.addAttribute("page", page);
        return "back/advertise/addProductToAdvertise";
    }







}
