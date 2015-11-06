package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner,
			QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleScanner = consoleScanner;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());

		List<Category> categories = categoryStorage.getAllCategories();
		consolePrinter.print(categories);

		int selectedCategory;
		do {
			consolePrinter.print("Please select category (0 for exit): ");
			selectedCategory = consoleScanner.getInt();

			consolePrinter.print("You selected category number " + selectedCategory);
			// show selected category
		} while(selectedCategory != 0 );
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
