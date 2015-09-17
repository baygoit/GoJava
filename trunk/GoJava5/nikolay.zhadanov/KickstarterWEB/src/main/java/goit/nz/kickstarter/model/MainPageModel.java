package goit.nz.kickstarter.model;

import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.domain.Quote;

import java.util.List;

public class MainPageModel {
	private Quote quote;
	private List<Category> categories;

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Quote getQuote() {
		return quote;
	}

	public List<Category> getCategories() {
		return categories;
	}

}
