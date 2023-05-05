package com.ispan.CCCMaster.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.model.bean.service.MessageModel;
import com.ispan.CCCMaster.service.MessageService;

@Controller
public class ServiceAdminController {


	@Autowired
	private MessageService mService;
	
    @GetMapping("/admin/Service/console")
	public String addMessage(Model model) {
    	
    	model.addAttribute("messages", new MessageModel());
    	
    	MessageModel latest = mService.getLatest();

    	model.addAttribute("latest", latest);
		return "back/service/Service-console";
	}
    
    @PostMapping("/messages/post")
    public String postMessage(@ModelAttribute("messages") MessageModel msg,Model model) {
		mService.addMessage(msg);
		
		model.addAttribute("messages", new MessageModel());
		
		MessageModel latest = mService.getLatest();
		
		model.addAttribute("latest", latest);
		

		return "back/service/Service-console";
    	
    }
    
   @GetMapping("/messages/ajax")
   public String ajaxPage() {
	   
	   return "back/ajaxMessage";
   }
}
