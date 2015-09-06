package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.domain.Quote;

import java.util.List;

public class MainPageModel {
	private QuoteDAO quoteDAO;
	private Quote randomQuote;
	private CategoryDAO categoryDAO;
	private List<Category> categories;

	public MainPageModel(QuoteDAO quoteDAO, CategoryDAO categoryDAO) {
		this.quoteDAO = quoteDAO;
		this.categoryDAO = categoryDAO;
	}

	public void update() {
		randomQuote = quoteDAO.getRandomQuote();
		categories = categoryDAO.getCategories();
	}

	public Quote getQuote() {
		return randomQuote;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
