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
			CategoryService cs = null;
			List<Category> categories = null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				cs = new DBcategoryServiceImpl(conn);
			} catch (KickstarterException e1) {
				cs = new DefaultCategoryServiceImpl();
			}
			categories = cs.getAll();
			return categories;
		}
		if (name.equals("quote")) {
			Quote quote = null;
			QuoteService qs = null;
			try {
				Connection conn = Pool.getInstance().getConnection();
				qs = new DBquoteService(conn);
			} catch (KickstarterException e1) {
				qs = new DefaultQuoteServiceImpl();
			}
			quote = qs.getRandomQuote();
			return quote;
		}
		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		// TODO Auto-generated method stub
	}
}
