package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;

@Controller
public class CategoryController {
	    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private ProjectDAO projectDAO;
	    
	@RequestMapping({"/categories", "/"})
	public String showCategories(Model model) {	
		model.addAttribute("topCategories", categoryDAO.getTopDonated(5));
		return "categories";
	}
	
	@RequestMapping("/category")
	public String showProjectsInCategory(Model model, @RequestParam(name = "id") Long categoryId) {
		model.addAttribute("category", categoryDAO.get(categoryId));
		model.addAttribute("projects", projectDAO.getByCategory(categoryId));
		return "projectList";
	}
	
}
