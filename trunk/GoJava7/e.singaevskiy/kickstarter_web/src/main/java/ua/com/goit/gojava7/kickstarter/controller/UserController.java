package ua.com.goit.gojava7.kickstarter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava7.kickstarter.datasource.contract.UserDAO;
import ua.com.goit.gojava7.kickstarter.domain.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userDAO;
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
	
	@RequestMapping("/signup")
	public String showSignUpForm(Model model) {
		return "signUp";
	}
	
	@RequestMapping("/login")
	public String showLoginPage(Model model) {
		return "login";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signUp(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "signUp";
		} else {
			userDAO.add(user);
			return "redirect:/";
		}
	}

}
