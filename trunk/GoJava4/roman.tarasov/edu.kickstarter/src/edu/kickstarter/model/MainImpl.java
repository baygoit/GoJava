package edu.kickstarter.model;

import java.util.List;

import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Category;
import edu.kickstarter.entity.Quote;

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
