package com.ispan.CCCMaster.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.Forum.Response;
import com.ispan.CCCMaster.service.ResponseService;

@Controller
public class ResponseAdminController {
    @Autowired
    private ResponseService responseService;

    @GetMapping("/admin/responses")
    public String findAllResponses(Model model) {
        List<Response> responses = responseService.findAllResponses();
        model.addAttribute("responses", responses);
        Response latest = responseService.getLatest();
        model.addAttribute("latest", latest);
        return "back/response/showResponse";
    }

    @DeleteMapping("/admin/responses/delete")
    public String putEditedResponse(@RequestParam("id") Integer id) {
        responseService.deleteResponseById(id);
        return "redirect:/admin/responses";
    }
}
