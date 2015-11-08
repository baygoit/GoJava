package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;
import java.util.ArrayList;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	public static void main(String[] args) throws IOException {
		QuoteStorage quoteStorage = initQuotes();
		CategoryStorage categoryStorage = initCategories();
		ConsolePrinter consolePrinter = new ConsolePrinter();
		
		consolePrinter.print(quoteStorage.getRandomQuote());
		
		ArrayList<Category> categories = categoryStorage.getAllCategories();
		int idOfSelectedCategory;
		do {
			consolePrinter.print("");
			consolePrinter.print(categories);
			consolePrinter.print("Please select catogory or type " + 0 + " to exit");
			idOfSelectedCategory = ConsoleScanner.getInt();
			
			if (idOfSelectedCategory < 0 || idOfSelectedCategory > categories.size()) {
				consolePrinter.print("Please enter the number in range from 0 to " + categories.size());
			}
			else if (idOfSelectedCategory != 0) {
				consolePrinter.print("You selected category number " + idOfSelectedCategory);
				Category category = categoryStorage.getCategory(idOfSelectedCategory - 1);
				consolePrinter.print(category.getName());
			}
			else {
				consolePrinter.print("You entered 0. Come again.");
			}
		} while (idOfSelectedCategory != 0);
		
	}
	
	private static CategoryStorage initCategories() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.addCategory(new Category("Art"));
		categoryStorage.addCategory(new Category("Comics"));
		categoryStorage.addCategory(new Category("Crafts"));
		categoryStorage.addCategory(new Category("Dance"));
		categoryStorage.addCategory(new Category("Design"));
		return categoryStorage;
	}

	private static QuoteStorage initQuotes() {
		QuoteStorage quoteStorage = new QuoteStorage();
		
		quoteStorage.add(new Quote(
				"No truly great person ever thought themselves so.", "William Hazlitt"));
		quoteStorage.add(new Quote(
				"I always look forward to working with Goldie "
				+ "because she's a great person to work with.", "Kurt Russell"));
	return quoteStorage;
	}
}
