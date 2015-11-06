package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ConsolePrinter consolePrinter;

	public Kickstarter(ConsolePrinter consolePrinter,
			QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());

		List<Category> categories = categoryStorage.getAllCategories();
		consolePrinter.print(categories);

		// ask use to select 1
		// read user input
		// show selected category

	}

}
