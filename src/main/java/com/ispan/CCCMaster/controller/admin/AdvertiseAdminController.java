package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import com.ispan.CCCMaster.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdvertiseAdminController {


    private final AdvertiseService advertiseService;

    public AdvertiseAdminController(AdvertiseService advertiseService) {
        this.advertiseService = advertiseService;
    }


    @GetMapping("/admin/advertises/createform")
    public String addAdvertise(Model model) {
        model.addAttribute("advertiseRequest", new AdvertiseRequest());

        return "back/advertise/advertise-create";
    }

    @PostMapping("/admin/advertises/create")
    public String createAdvertise(@ModelAttribute("advertiseRequest") AdvertiseRequest advertiseRequest, Model model) {

        advertiseService.createAdvertise(advertiseRequest);
        return "redirect:/admin/advertises/showAllAdvertise";
    }

    @GetMapping("/admin/advertises/showAllAdvertise")
    public String showAllAdvertise(@RequestParam(name = "p",defaultValue = "1")Integer pageNumber,Model model) {
        Page<Advertise> page = advertiseService.findByPage(pageNumber);
        model.addAttribute("page",page);
        Advertise latest = advertiseService.getLatestAdvertise();
        model.addAttribute("latest",latest);


        return "back/advertise/showAdvertise";
    }

    public String deleteAdvertiseById(@RequestParam("id") Integer id) {
        advertiseService.deleteAdvertiseById(id);
        return "redirect:/admin/advertises/showAllAdvertise";
    }

}
