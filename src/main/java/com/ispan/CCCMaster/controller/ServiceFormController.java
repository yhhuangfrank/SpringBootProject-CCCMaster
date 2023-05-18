package com.ispan.CCCMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.annotation.CustomerAuthentication;
import com.ispan.CCCMaster.model.bean.service.ReportForm2Model;
import com.ispan.CCCMaster.service.ServiceFromService;

@Controller
public class ServiceFormController {
	
    @Autowired
    private ServiceFromService Sservice;

    @CustomerAuthentication
    @GetMapping("/service/from/create/{customerid}")//新增回報表單
    public String getReportFormsByCustomerId(
            @PathVariable Integer customerid,
            @RequestParam(name="p",defaultValue = "1" ) Integer pageNumber,Model model) {
    	Page<ReportForm2Model> page = Sservice.findByPageId(pageNumber, customerid);
    	
    	model.addAttribute("page",page);

        model.addAttribute("ReportForm", new ReportForm2Model());
        return "front/service/createServicefrom";
    }

    @CustomerAuthentication
    @PostMapping("/service/from/create/post")//新增回報表單送出
    public String createReportForm(ReportForm2Model ReportForm, RedirectAttributes attributes) {
    	Sservice.createform(ReportForm);

        attributes.addAttribute("customerid", ReportForm.getCustomerid());
        return "redirect:/service/from/create/{customerid}";
    }

    
    //後端顯示全部表單
    @GetMapping("/admin/Service/findform")
	public String findallform(@RequestParam(name="p",defaultValue = "1" ) Integer pageNumber,Model model) {
    	Page<ReportForm2Model> page = Sservice.findByPage(pageNumber);
    	
    	model.addAttribute("page",page);
    	
		return "back/service/Service-formfindall";
	}
    
    //後台回覆表單
    @GetMapping("/admin/Service/findform/Reply")
    public String editPage(@RequestParam("id") Integer id, Model model) {
    	ReportForm2Model form = Sservice.findReportFormById(id);
    	
    	model.addAttribute("ReportForm", form);
    	
    	return "back/service/Service-ReplyForm";
    }
    //後臺回覆表單

	@PutMapping("/admin/Service/findform/Reply")
	public String putEditedMessage(@ModelAttribute("id") ReportForm2Model form) {
		Sservice.updateById(form.getId(), form.getReply());
		return "redirect:/admin/Service/findform";
	}
    //後台刪除表單
    @DeleteMapping("/admin/Service/findform/delete")
	public String deleteForm(@RequestParam Integer id) {
    	Sservice.deleteReportFormById(id);
		return "redirect:/admin/Service/findform";
	}
    
    

}

