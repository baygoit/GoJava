package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static view.eViews.*;
import view.ViewFactory;
import dao.category.Category;
import dao.category.CategoryService;
import dao.category.DefaultCategoryServiceImpl;
import dao.pool.KickstarterException;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.Quote;
import dao.quote.QuoteService;

public class NewMainModel implements iModel {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public NewMainModel(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
	}

	@Override
	public void execute() throws KickstarterException {
		QuoteService quoteService = new DefaultQuoteServiceImpl();
		Quote quote = quoteService.getRandomQuote();
		ViewFactory factory = new ViewFactory(CATEGORIES, request, response);
		factory.setAttribute("quote", quote);
		
		CategoryService categoryService = new DefaultCategoryServiceImpl();
		List<Category> categories = null;

		categories = categoryService.getAll();
		factory.setAttribute("categories", categories);
		
		factory.forward();
	}
}
