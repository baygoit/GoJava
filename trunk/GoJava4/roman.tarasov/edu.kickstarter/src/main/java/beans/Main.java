package beans;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static view.eViews.*;
import view.ViewDispatcher;
import view.ViewStrategy;
import dao.category.Category;
import dao.category.CategoryService;
import dao.category.DBcategoryServiceImpl;
import dao.category.DefaultCategoryServiceImpl;
import dao.pool.KickstarterException;
import dao.quote.DBquoteServiceImpl;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.Quote;
import dao.quote.QuoteService;

public class Main extends DatabaseConnectionChecker implements iBean {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {

		QuoteService quoteService = null;
		CategoryService categoryService = null;
		if (connected()) {
			quoteService = new DBquoteServiceImpl();
			categoryService = new DBcategoryServiceImpl();
		} else {
			quoteService = new DefaultQuoteServiceImpl();
			categoryService = new DefaultCategoryServiceImpl();
		}

		Quote quote = quoteService.getRandomQuote();
		ViewDispatcher view = ViewStrategy.getInstance().selectView(CATEGORIES_V);
		request.setAttribute("quote", quote);

		List<Category> categories = null;
		categories = categoryService.getAll();
		request.setAttribute("categories", categories);
		view.forward(request, response);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub
		
	}
}
