package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

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
		
		Quote quote = quoteDao.getRandomQuote();
		modelAndView.addObject("quote", quote);
		log.debug("Random quote: {}", quote);
		
		List<Category> categories = categoryDao.getCategories();
		modelAndView.addObject("categories", categories);
		log.debug("Categories: {}", categories);
		
		return modelAndView;
	}

}
