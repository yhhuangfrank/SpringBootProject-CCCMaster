package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


        return "back/advertise/editAdvertise";
    }
    @PutMapping("/admin/advertises/editPage")
    public String updateAdvertiseById(@RequestParam("id") Integer advertiseId, Model model) {
        Advertise advertiseById = advertiseService.findAdvertiseById(advertiseId);

        model.addAttribute("advertise", advertiseById);
        return "back/advertise/editAdvertise";
    }

    @PutMapping("/admin/advertises/edit")
    public String putEditedAdvertise(@ModelAttribute("advertise") Advertise advertise) {
        advertiseService.updateAdvertiseById(advertise);
        return "redirect:/admin/advertises/showAllAdvertise";
    }


    @DeleteMapping("/admin/advertises/delete")
    public String deleteAdvertiseById(@RequestParam("id") Integer id) {
        advertiseService.deleteAdvertiseById(id);
        return "redirect:/admin/advertises/showAllAdvertise";
    }

}
