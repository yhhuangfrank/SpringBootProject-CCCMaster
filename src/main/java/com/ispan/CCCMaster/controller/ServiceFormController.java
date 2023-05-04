package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;
import com.ispan.CCCMaster.service.ServiceFromService;

@Controller
public class ServiceFormController {
	
    @Autowired
    private ServiceFromService Sservice;


    @GetMapping("/service/from/create")//新增回報表單
    public String getCreateReportForm(Model model) {
        model.addAttribute("ReportForm", new ReportForm2Model());
        return "front/service/createServicefrom";
    }

    @PostMapping("/service/from/create/post")//新增回報表單送出
    public String createReportForm(@ModelAttribute("ReportForm") ReportForm2Model ReportForm) {
    	

        return "redirect:/admin/products/showAllProduct";
    }

    

}

