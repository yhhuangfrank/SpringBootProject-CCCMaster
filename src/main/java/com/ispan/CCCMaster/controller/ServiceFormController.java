package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;
import com.ispan.CCCMaster.service.ServiceFromService;

@Controller
public class ServiceFormController {
	
    @Autowired
    private ServiceFromService Sservice;

    
    @GetMapping("/service/from/create/{customerid}")//新增回報表單
    public String getReportFormsByCustomerId(
            @PathVariable Integer customerid,
            @RequestParam(name="p",defaultValue = "1" ) Integer pageNumber,Model model) {
    	Page<ReportForm2Model> page = Sservice.findByPage(pageNumber, customerid);
    	
    	model.addAttribute("page",page);

        model.addAttribute("ReportForm", new ReportForm2Model());
        return "front/service/createServicefrom";
    }
    
    @PostMapping("/service/from/create/post")//新增回報表單送出
    public String createReportForm(ReportForm2Model ReportForm, RedirectAttributes attributes) {
    	Sservice.createform(ReportForm);

        attributes.addAttribute("customerid", ReportForm.getCustomerid());
        return "redirect:/service/from/create/{customerid}";
    }
    

}

