package model;

import java.util.List;

import dao.Dao;
import dao.category.Category;
import dao.quote.Quote;
import database.KickstarterException;

public class MainImpl implements Model {
	public MainImpl() {
		Dao.getInstance();
	}

	@Override
	public Object getAttribute(String name) throws KickstarterException {
		if (name.equals("categories")) {
			List<Category> categories = Dao.getCategoryService().getAll();
			return categories;
		}
		if (name.equals("quote")) {
			Quote quote = Dao.getQuoteService().getRandomQuote();
			return quote;
		}

		return null;
	}

	@Override
	public void setParameters(Object parameter) {
		// TODO Auto-generated method stub

	}
}
