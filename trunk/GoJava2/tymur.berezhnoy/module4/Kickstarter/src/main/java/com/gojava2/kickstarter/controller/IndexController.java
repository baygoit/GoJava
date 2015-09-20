package com.gojava2.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gojava2.kickstarter.service.CategoryService;
import com.gojava2.kickstarter.service.QuoteService;

@Controller
public class IndexController {
	
	@Autowired
	private QuoteService quoteService; 

	@Autowired
    private CategoryService categoryService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("quote", quoteService.getRandomQuote());
		model.addAttribute("categories", categoryService.getCategories());
		return "index";
	}
}