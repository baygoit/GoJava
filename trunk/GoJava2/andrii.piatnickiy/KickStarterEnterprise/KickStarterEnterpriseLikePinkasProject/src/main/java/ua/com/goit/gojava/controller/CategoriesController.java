package ua.com.goit.gojava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.goit.gojava.service.CategoryService;

@Controller
public class CategoriesController {

	@Autowired
	private CategoryService categoryService; 
	
	@RequestMapping("/categories")
	public String categories(Model model){
		model.addAttribute("categories", categoryService.findAll());
		return "categories";
	}
	
	@RequestMapping("/categories/{id}")
	public String detail(Model model, @PathVariable int id){
		model.addAttribute("category", categoryService.findOneWithProject(id));
		return "category";
	}
	
}
