package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = initQuotes();

		ConsolePrinter.println(quoteStorage.getRandomQuote());

		// show all categories with index
		CategoryStorage categoryStorage = new CategoryStorage();
		// ConsolePrinter.println(categoryStorage);

		List<String> categories = categoryStorage.getAllCategories();

		// ConsolePrinter.printlnListWithIndexes(categories);

		// CategoriesPrinter cp cs

		// CS => LIst<String> => List<Category>

		for (int i = 0; i < categories.size(); i++) {
			// ConsolePrinter.println(i + " : " + categories.get(i));
		}
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
}
