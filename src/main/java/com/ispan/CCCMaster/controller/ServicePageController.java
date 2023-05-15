package com.ispan.CCCMaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicePageController {

	
    @GetMapping("Service/common")
	public String common(Model model) {
    	
		return "front/service/common/common";
	}

    @GetMapping("Service/common/order")
	public String commonOrder(Model model) {
    	
		return "front/service/common/common-order";
	}
    
    @GetMapping("Service/common/delivery")
	public String commondelivery(Model model) {
    	
		return "front/service/common/common-delivery";
	}

    @GetMapping("Service/common/Refund")
	public String commonRefund(Model model) {
    	
		return "front/service/common/common-Refund";
	}
    @GetMapping("Service/common/discount")
	public String commondiscount(Model model) {
    	
		return "front/service/common/common-discount";
	}
    @GetMapping("Service/common/Activity")
	public String commonActivity(Model model) {
    	
		return "front/service/common/common-Activity";
	}
    @GetMapping("Service/common/Account")
	public String commonAccount(Model model) {
    	
		return "front/service/common/common-Account";
	}

        @GetMapping("/message/chat")
        public String home(Model model) {
            model.addAttribute("message", "Hello, world!");
            return "front/service/index";
        }
        @GetMapping("/admin/Service/console")
    	public String addMessage(Model model) {
        	
        	

    		return "back/service/Service-console";
    	}
}
