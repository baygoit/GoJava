package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {

	private static QuoteStorage quoteStorage;
	private static CategoryStorage categoryStorage;
	private static ConsolePrinter consolePrinter;

	public static void main(String[] args) {
		quoteStorage = initQuotes();
		categoryStorage = initCategories();
		consolePrinter = new ConsolePrinter();

		consolePrinter.print(quoteStorage.getRandomQuote());

		List<Category> categories = categoryStorage.getAllCategories();
		consolePrinter.print(categories);

		// ask use to select 1
		// read user input
		// show selected category
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage
				.add(new Quote(
						"Your work is going to fill a large part of your life,"
								+ " and the only way to be truly satisfied is to do what"
								+ " you believe is great work. And the only way to do"
								+ " great work is to love what you do. If you haven't"
								+ " found it yet, keep looking. Don't settle. As with"
								+ " all matters of the heart, you'll know when you"
								+ " find it.", "Steve Jobs"));
		quoteStorage.add(new Quote(
				"Innovation distinguishes between a leader and a follower.",
				"Steve Jobs"));
		return quoteStorage;
	}

	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.add(new Category("Movie"));
		categoryStorage.add(new Category("Dances"));
		categoryStorage.add(new Category("Food"));
		return categoryStorage;
	}
}
