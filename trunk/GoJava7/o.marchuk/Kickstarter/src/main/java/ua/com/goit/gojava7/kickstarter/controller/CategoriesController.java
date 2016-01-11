package ua.com.goit.gojava7.kickstarter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;

@Controller
public class CategoriesController {

	private static final Logger log = LoggerFactory.getLogger(CategoriesController.class);
	
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping("/categories")
	public ModelAndView categories() {
		ModelAndView modelAndView = new ModelAndView("categories");
		modelAndView.addObject("quote", quoteDao.getRandomQuote());
		modelAndView.addObject("categories", categoryDao.getAll());
		return modelAndView;
	}

	@RequestMapping("/category")
	public ModelAndView category(@RequestParam(name = "id") Long categoryId) {
		ModelAndView modelAndView = new ModelAndView("category");
		Category category = categoryDao.get(categoryId);
		category.getProjects();
		
		log.debug("Category: {}", category);
		log.debug("Category projects: {}", category.getProjects());
		
		modelAndView.addObject(category);
		return modelAndView;
	}
}