package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.QuoteDAO;
import goit.nz.kickstarter.memory.Category;
import goit.nz.kickstarter.memory.Quote;
import goit.nz.kickstarter.storage.DataStorage;

import java.util.List;

public class MainPageModel {

	private QuoteDAO quoteDAO;
	private Quote randomQuote;
	private CategoryDAO categoryDAO;
	private List<Category> categories;

	public MainPageModel(DataStorage storage) {
		quoteDAO = new QuoteDAO(storage);
		categoryDAO = new CategoryDAO(storage);
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
