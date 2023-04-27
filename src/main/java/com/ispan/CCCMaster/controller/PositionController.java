package com.ispan.CCCMaster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.CCCMaster.model.bean.Position;
import com.ispan.CCCMaster.service.PositionService;

@Controller
public class PositionController {
	
	@Autowired
	private PositionService pstService;
	
	@GetMapping("/positions")	//職位編號總覽
	public String showAll(Model model) {
		List<Position> positions = pstService.findAll();
		model.addAttribute("positions", positions);
		return "back/position/positions";
	}
	
	@GetMapping("/positions/create")	//新增職位頁面
	public String createPosition(Model model) {
		model.addAttribute("position", new Position());
		return "back/position/create";
	}
	
	@PostMapping("/positions/create")	//送出新增職位表單
	public String postPosition(@ModelAttribute("position") Position position) {
		pstService.createPosition(position);
		return "redirect:/positions";	//之後路徑要改成總覽的
	}

}
