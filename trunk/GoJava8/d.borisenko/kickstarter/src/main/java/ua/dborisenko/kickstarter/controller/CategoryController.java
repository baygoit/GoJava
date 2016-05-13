package ua.dborisenko.kickstarter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.dborisenko.kickstarter.dao.CategoryDao;
import ua.dborisenko.kickstarter.dao.QuoteDao;

@Controller
public class CategoryController {

	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showCategories(Map<String, Object> model) {
		model.put("quote", quoteDao.getRandom());
		model.put("categories", categoryDao.getAll());
		return "categories";
	}
}
