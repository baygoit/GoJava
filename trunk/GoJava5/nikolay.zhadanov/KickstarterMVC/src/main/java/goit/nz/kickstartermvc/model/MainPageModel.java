package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.dao.Category;
import goit.nz.kickstartermvc.dao.Quote;
import goit.nz.kickstartermvc.storage.DataStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPageModel {

	private DataStorage storage;
	private List<Category> categories;

	public MainPageModel(DataStorage storage) {
		this.storage = storage;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}

	public String getRandomQuote() {
		Random generator = new Random();
		List<Quote> quotes = storage.getQuotes();
		String result = "";
		if (quotes.size() > 0) {
			Quote randomQuote = quotes.get(generator.nextInt(quotes.size()));
			result = String.format("%s\n%s", randomQuote.getText(),
					randomQuote.getAuthor());
		}
		return result;
	}

	public int size() {
		return categories.size();
	}

	public void update() {
		categories = new ArrayList<>();
		categories.addAll(storage.getCategories());
	}
}
