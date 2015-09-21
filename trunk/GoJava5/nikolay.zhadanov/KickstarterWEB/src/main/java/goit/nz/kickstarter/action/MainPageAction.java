package goit.nz.kickstarter.action;

import goit.nz.kickstarter.model.MainPageModel;
import goit.nz.kickstarter.service.CategoryService;
import goit.nz.kickstarter.service.QuoteService;

import javax.servlet.http.HttpServletRequest;

public class MainPageAction implements Action {
	private MainPageModel model;
	private QuoteService quoteService;
	private CategoryService categoryService;
	private final String VIEW = "main";

	public void setQuoteService(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		model = new MainPageModel();
		model.setQuote(quoteService.getRandomQuote());
		model.setCategories(categoryService.getCategories());
		request.setAttribute("model", model);
		return VIEW;
	}

}
