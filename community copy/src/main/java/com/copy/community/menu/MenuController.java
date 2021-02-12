package com.copy.community.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/temp")
public class MenuController {

	@Autowired
	private MenuService service;
	
	@GetMapping("/header")
	public void header(Model model) {
		model.addAttribute("menuList", service.selMenuList());
	}
}
