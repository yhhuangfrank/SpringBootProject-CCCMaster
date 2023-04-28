package com.ispan.CCCMaster.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.CCCMaster.model.bean.employee.Position;
import com.ispan.CCCMaster.service.PositionService;

@Controller
public class PositionAdminController {
	
	@Autowired
	private PositionService pstService;
	
	@GetMapping("/admin/positions")	//職位編號總覽
	public String showAll(Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("positions", positions);
		return "back/position/positions";
	}
	
	@GetMapping("/admin/positions/create")	//新增職位頁面
	public String createPosition(Model model) {
		model.addAttribute("position", new Position());
		return "back/position/create";
	}
	
	@PostMapping("/admin/positions/create")	//送出新增職位表單
	public String postPosition(@ModelAttribute("position") Position position) {
		pstService.createPosition(position);
		return "redirect:/admin/positions";
	}
	
	// 還沒寫完
	@GetMapping("/admin/positions/edit")
	public String editPosition(@RequestParam("id") Integer id) {
		return "back/position/edit";
	}
	
	// 還沒寫完
	@PutMapping("/admin/positions/edit")	//編輯職位按鈕
	public String putPosition() {
		return null;
	}
	
	@DeleteMapping("/admin/positions/delete")	//刪除職位按鈕
	public String deletePosition(@RequestParam("id") Integer id) {
		pstService.deleteById(id);
		return "redirect:/admin/positions";
	}

}
