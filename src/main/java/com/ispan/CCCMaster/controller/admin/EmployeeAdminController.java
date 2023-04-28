package com.ispan.CCCMaster.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.service.EmployeeService;

@Controller
public class EmployeeAdminController {
	
	@Autowired
	private EmployeeService epyService;
	
	@GetMapping("/employees/create")
	public String createEmployee() {
		return "back/employee/create";
	}

}
