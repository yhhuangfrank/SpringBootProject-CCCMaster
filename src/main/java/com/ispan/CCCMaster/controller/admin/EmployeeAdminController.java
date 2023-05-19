package com.ispan.CCCMaster.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ispan.CCCMaster.annotation.EmployeeAuthentication;
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
	
	@GetMapping("/admin/login")	//後台員工登入頁面
	public String loginPage() {
		return "back/employee/login";
	}
	
	@PostMapping("/admin/login")	//打完帳號密碼，送出表單
	public  String login(@RequestParam("employeeId") Integer employeeId
						, @RequestParam("password") String password
						, HttpServletRequest request
						, RedirectAttributes redirectAttributes) {
		if(epyService.logIn(employeeId, password, request)) {
			return "redirect:/admin/customers";	//若成功登入，導到會員資料總覽
		} else {
			//重導前添加登入失敗訊息
			redirectAttributes.addFlashAttribute("isFailed", true);
			redirectAttributes.addFlashAttribute("failedMsg", "登入失敗！員工編號或密碼錯誤!");
			return "redirect:/admin/login";
		}
	}
	
	@EmployeeAuthentication
	@GetMapping("/admin/logout")	//按下登出鈕
	public String logOut(HttpSession session, RedirectAttributes redirectAttributes) {
		epyService.logOut(session);
		redirectAttributes.addFlashAttribute("isSuccess", true);
		redirectAttributes.addFlashAttribute("successMsg", "你已成功登出");
		return "redirect:/admin/login";	//回到登入頁
	}
	
	@GetMapping("/admin/cancelLogin")	//按下不想上班鈕
	public String cancelLogin(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("lazy_float", true);
		redirectAttributes.addFlashAttribute("lazyMsg_float", "不可以ㄛ，你不能那麼做 ^_^");
		return "redirect:/admin/login";	//回到登入頁
	}
	
	@EmployeeAuthentication
	@GetMapping("/admin/employees")	//員工資料總覽
	public String showAll(@RequestParam(name="p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<Employee> page = epyService.findByPage(pageNumber);
		model.addAttribute("page", page);
		return "back/employee/employees";
	}
	
	@EmployeeAuthentication
	@GetMapping("/admin/employees/create")	//新增員工頁面
	public String createEmployee(Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("employee", new Employee());
		model.addAttribute("positions", positions);
		return "back/employee/create";
	}
	
	@EmployeeAuthentication
	@PostMapping("/admin/employees/create")	//送出新增員工表單
	public String postEmployee(@ModelAttribute("employee") Employee employee) {
		epyService.createEmployee(employee);
		return "redirect:/admin/employees";	//總覽的GetMapping路徑
	}
	
	@EmployeeAuthentication
	@GetMapping("/admin/employees/edit")	//編輯員工資料頁面
	public String editEmployee(@RequestParam("id") Integer id, Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("positions", positions);
		model.addAttribute("employee", epyService.findById(id));
		return "back/employee/edit";
	}
	
	@EmployeeAuthentication
	@PutMapping("/admin/employees/edit")	//送出編輯員工資料表單
	public String putEmployee(@ModelAttribute("employee") Employee employee) {
		epyService.editById(employee);
		return "redirect:/admin/employees";
	}
	
	@EmployeeAuthentication
	@DeleteMapping("/admin/employees/delete")	//刪除員工按鈕
	public String deleteEmployee(@RequestParam("id") Integer id) {
		epyService.deleteById(id);
		return "redirect:/admin/employees";
	}

}
