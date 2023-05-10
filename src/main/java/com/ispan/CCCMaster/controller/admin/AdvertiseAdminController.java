package com.ispan.CCCMaster.controller.admin;

import com.ispan.CCCMaster.model.bean.Advertise.Advertise;
import com.ispan.CCCMaster.model.dto.AdvertiseRequest;
import com.ispan.CCCMaster.service.AdvertiseService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/admin/advertises/{id}editPage")
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
        return "back/advertise/editAdvertise";
    }


    @DeleteMapping("/admin/advertises/delete")
    public String deleteAdvertiseById(@RequestParam("id") Integer id) {
        advertiseService.deleteAdvertiseById(id);
        return "redirect:/admin/advertises/showAllAdvertise";
    }

}
