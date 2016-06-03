package com.anmertrix.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;

@Controller
public class CategoriesController {
	
	@Autowired
	private QuoteDao quoteDao;
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showIndex(Map<String, Object> model) {
		return "index";
	}
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String showCategories(Map<String, Object> model) {
		model.put("quote", quoteDao.getRandomQuote());
		model.put("categories", categoryDao.getCategories());
		return "categories";
	}
	
}
