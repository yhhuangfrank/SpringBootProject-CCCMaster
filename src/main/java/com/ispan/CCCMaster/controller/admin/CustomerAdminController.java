package com.ispan.CCCMaster.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.customer.Customer;
import com.ispan.CCCMaster.service.CustomerService;

@Controller
public class CustomerAdminController {
	
	@Autowired
	private CustomerService ctmService;
	
	@GetMapping("/admin/customers")	//會員資料總覽
	public String showAll(@RequestParam(name="p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Customer> page = ctmService.findByPage(pageNumber);
		model.addAttribute("page", page);
		return "back/customer/customers";
	}
	
	@GetMapping("/admin/customers/create")	//新增會員頁面
	public String createCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "back/customer/create";
	}
	
	@PostMapping("/admin/customers/create")	//送出新增會員表單
	public String postCustomer(@ModelAttribute("customer") Customer customer) {
		ctmService.createCustomer(customer);
		return "redirect:/admin/customers";	//總覽的GetMapping路徑
	}
	
	@GetMapping("/admin/customers/edit")	//編輯會員資料頁面
	public String editCustomer(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("customer", ctmService.findById(id));
		return "back/customer/edit";
	}
	
	@PutMapping("/admin/customers/edit")	//送出編輯會員資料表單
	public String putCustomer(@ModelAttribute("customer") Customer customer) {
		ctmService.editById(customer);
		return "";
	}
	
	@DeleteMapping("/admin/customers/delete")	//刪除會員按鈕
	public String deleteCustomer(@RequestParam("id") Integer id) {
		ctmService.deleteById(id);
		return "redirect:/admin/customers";
	}

}
