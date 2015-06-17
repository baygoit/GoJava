package model;

import java.sql.Connection;
import java.util.List;
import dao.category.Category;
import dao.category.CategoryService;
import dao.category.DBcategoryServiceImpl;
import dao.category.DefaultCategoryServiceImpl;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.quote.DBquoteService;
import dao.quote.DefaultQuoteServiceImpl;
import dao.quote.Quote;
import dao.quote.QuoteService;

public class MainImpl implements Model {

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		if (name.equals("categories")) {
			CategoryService categoryService = null;
			List<Category> categories = null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				categoryService = new DBcategoryServiceImpl(conn);
			} catch (KickstarterException e1) {
				categoryService = new DefaultCategoryServiceImpl();
			}
			categories = categoryService.getAll();
			return categories;
		}
		if (name.equals("quote")) {
			Quote quote = null;
			QuoteService quoteService = null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				quoteService = new DBquoteService(conn);
			} catch (KickstarterException e1) {
				quoteService = new DefaultQuoteServiceImpl();
			}
			quote = quoteService.getRandomQuote();
			return quote;
		}
		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		// TODO Auto-generated method stub
	}
}
