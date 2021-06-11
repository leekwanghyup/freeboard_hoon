package com.freehoon.web.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.freehoon.web.board.model.MenuVO;

@Controller
@RequestMapping("/menu")
public class MenuController {
	 
	@GetMapping("/getMenu")	
	public String getMenuList(Model model){ 
		model.addAttribute("menuVO", new MenuVO()); 
		return "menu/menu"; 
	}
	
}
