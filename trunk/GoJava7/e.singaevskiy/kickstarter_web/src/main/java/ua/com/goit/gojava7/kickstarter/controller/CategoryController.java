package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@Controller
public class CategoryController {
	
	@Autowired
    private QuoteDAO quoteDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private ProjectDAO projectDAO;
	
	@RequestMapping("/*")
	public ModelAndView showMenu(ModelAndView model) {
		System.out.println("showMenu");
		System.out.println(model.getViewName());
		Random rnd = new Random();       
        List<Quote> quotes = quoteDAO.getAll();     
		
		//ModelAndView modelAndView = new ModelAndView("categories");
		model.addObject("quote", quotes.get(rnd.nextInt(quotes.size())));
		model.addObject("categories", categoryDAO.getAll());
		//model.addAttribute("topCategories", categoryDAO.getTopDonated(5));
		return model;
	}
    
	@RequestMapping({"/categories", "/"})
	public ModelAndView showCategories() {
		System.out.println("showCategories");
		
		ModelAndView modelAndView = new ModelAndView("categories");
		
		Random rnd = new Random();       
		List<Quote> quotes = quoteDAO.getAll();
		modelAndView.addObject("quote", quotes.get(rnd.nextInt(quotes.size())));
		modelAndView.addObject("categories", categoryDAO.getAll());
		modelAndView.addObject("topCategories", categoryDAO.getTopDonated(5));
		return modelAndView;
	}
	
	@RequestMapping("/category")
	public ModelAndView showProjectsInCategory(@RequestParam(name = "id") Integer categoryId) {
		System.out.println("showProjectsInCategory");
		ModelAndView modelAndView = new ModelAndView("projectList");
		modelAndView.addObject("category", categoryDAO.get(categoryId));
		modelAndView.addObject("projects", projectDAO.getByCategory(categoryId));
		return modelAndView;
	}
	
}
