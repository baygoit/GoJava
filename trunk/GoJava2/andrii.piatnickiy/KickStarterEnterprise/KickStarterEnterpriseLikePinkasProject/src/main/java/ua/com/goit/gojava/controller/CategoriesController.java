package ua.com.goit.gojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.goit.gojava.entity.User;
import ua.com.goit.gojava.service.CategoryService;
import ua.com.goit.gojava.service.UserService;

@Controller
public class CategoriesController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@RequestMapping("/categories")
	public String categories(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		return "categories";
	}

	@RequestMapping("/categories/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("category", categoryService.findOneWithProject(id));
		return "category";
	}
	
	@RequestMapping("/register")
	public String showRegister() {
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "register";
	}

	@RequestMapping("/users")
	public String showUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

}
