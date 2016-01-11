package ua.com.goit.gojava7.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@Controller
public class CategoriesController {

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
	public ModelAndView category() {
		return new ModelAndView("category", "model", new Object());
	}
}