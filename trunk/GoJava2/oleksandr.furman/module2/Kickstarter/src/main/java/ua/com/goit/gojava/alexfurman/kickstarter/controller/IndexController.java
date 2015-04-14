package ua.com.goit.gojava.alexfurman.kickstarter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.goit.gojava.alexfurman.kickstarter.service.CategoryService;
import ua.com.goit.gojava.alexfurman.kickstarter.service.QuoteService;

@Controller
public class IndexController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QuoteService quoteService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("quote", quoteService.getRandomQuote());
		return "index";
	}
}
