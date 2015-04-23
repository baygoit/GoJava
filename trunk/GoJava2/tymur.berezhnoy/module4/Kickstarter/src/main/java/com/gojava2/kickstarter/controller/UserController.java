package com.gojava2.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gojava2.kickstarter.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{name}")
	public String getUser(Model model, @PathVariable String name) {
		model.addAttribute("user", userService.getUser(name));
		return "user";
	}
}