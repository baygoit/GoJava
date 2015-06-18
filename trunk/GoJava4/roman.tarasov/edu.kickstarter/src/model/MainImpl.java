package model;

import java.sql.Connection;
import java.sql.SQLException;
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

			if (connected()) {
				categoryService = new DBcategoryServiceImpl();
			} else {
				categoryService = new DefaultCategoryServiceImpl();
			}
			categories = categoryService.getAll();
			return categories;
		}
		if (name.equals("quote")) {
			Quote quote = null;
			QuoteService quoteService = null;
			if (connected()) {
				quoteService = new DBquoteService();
			} else {
				quoteService = new DefaultQuoteServiceImpl();
			}
			quote = quoteService.getRandomQuote();
			return quote;
		}
		return null;
	}

	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {
		}
		return connected;
	}

	@Override
	public void setParameters(Object parameter) {
		// TODO Auto-generated method stub
	}
}
