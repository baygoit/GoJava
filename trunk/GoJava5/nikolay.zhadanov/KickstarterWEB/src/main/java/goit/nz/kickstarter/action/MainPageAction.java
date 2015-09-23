package goit.nz.kickstarter.action;

import goit.nz.kickstarter.service.CategoryService;
import goit.nz.kickstarter.service.QuoteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "main")
public class MainPageAction {
	private QuoteService quoteService;
	private CategoryService categoryService;
	private final String VIEW = "main";

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView execute() {
		ModelAndView model = new ModelAndView();
		model.addObject("quote", quoteService.getRandomQuote());
		model.addObject("categories", categoryService.getCategories());
		model.setViewName(VIEW);
		return model;
	}

}
