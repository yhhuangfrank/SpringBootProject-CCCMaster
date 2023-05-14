package com.ispan.CCCMaster.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.CCCMaster.model.dto.CustomerCheckRequest;
import com.ispan.CCCMaster.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerApi {
	
	@Autowired
	private CustomerService ctmService;
	
	@PostMapping("/checkEmail")
	public Boolean canEmailUse(@RequestBody CustomerCheckRequest ccr) {
		return ctmService.canEmailUse(ccr);
	}
	
	@PostMapping("/checkName")
	public Boolean canNameUse(@RequestBody CustomerCheckRequest ccr) {
		return ctmService.canNameUse(ccr);
	}

	@PostMapping("/checkPhoneNumber")
	public Boolean canPhoneNumberUse(@RequestBody CustomerCheckRequest ccr) {
		return ctmService.canPhoneNumberUse(ccr);
	}

}
