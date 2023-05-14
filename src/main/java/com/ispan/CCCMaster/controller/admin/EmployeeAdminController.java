package com.ispan.CCCMaster.controller.admin;

import java.util.List;

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

import com.ispan.CCCMaster.model.bean.employee.Employee;
import com.ispan.CCCMaster.model.bean.employee.Position;
import com.ispan.CCCMaster.service.EmployeeService;
import com.ispan.CCCMaster.service.PositionService;

@Controller
public class EmployeeAdminController {
	
	@Autowired
	private EmployeeService epyService;
	@Autowired
	private PositionService pstService;
	
	@GetMapping("/admin/employees")	//員工資料總覽
	public String showAll(@RequestParam(name="p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Employee> page = epyService.findByPage(pageNumber);
		model.addAttribute("page", page);
		return "back/employee/employees";
	}
	
	@GetMapping("/admin/employees/create")	//新增員工頁面
	public String createEmployee(Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("employee", new Employee());
		model.addAttribute("positions", positions);
		return "back/employee/create";
	}
	
	@PostMapping("/admin/employees/create")	//送出新增員工表單
	public String postEmployee(@ModelAttribute("employee") Employee employee) {
		epyService.createEmployee(employee);
		return "redirect:/admin/employees";	//總覽的GetMapping路徑
	}
	
	@GetMapping("/admin/employees/edit")	//編輯員工資料頁面
	public String editEmployee(@RequestParam("id") Integer id, Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("positions", positions);
		model.addAttribute("employee", epyService.findById(id));
		return "back/employee/edit";
	}
	
	@PutMapping("/admin/employees/edit")	//送出編輯員工資料表單
	public String putEmployee(@ModelAttribute("employee") Employee employee) {
		epyService.editById(employee);
		return "redirect:/admin/employees";
	}
	
	@DeleteMapping("/admin/employees/delete")	//刪除員工按鈕
	public String deleteEmployee(@RequestParam("id") Integer id) {
		epyService.deleteById(id);
		return "redirect:/admin/employees";
	}

}
