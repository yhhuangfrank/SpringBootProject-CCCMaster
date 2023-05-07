package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;
import com.ispan.CCCMaster.service.ServiceFromService;

@Controller
public class ServiceFormController {
	
    @Autowired
    private ServiceFromService Sservice;


    @GetMapping("/service/from/create")//新增回報表單
    public String getCreateReportForm(@RequestParam(name="p",defaultValue = "1" ) Integer pageNumber,Model model) {
    	Page<ReportForm2Model> page = Sservice.findByPage(pageNumber);
    	
    	model.addAttribute("page",page);
        model.addAttribute("ReportForm", new ReportForm2Model());
        return "front/service/createServicefrom";
    }

    @PostMapping("/service/from/create/post")//新增回報表單送出
    public String createReportForm(@ModelAttribute("ReportForm") @RequestParam(name="p",defaultValue = "1" ) Integer pageNumber,ReportForm2Model ReportForm,Model model) {
    	Sservice.createform(ReportForm);
    	Page<ReportForm2Model> page = Sservice.findByPage(pageNumber);
    	
    	model.addAttribute("page",page);

        model.addAttribute("ReportForm", new ReportForm2Model());
        return "front/service/createServicefrom";
    }

    

}

