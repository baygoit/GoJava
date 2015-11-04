package ua.com.goit.gojava7.kickstarter;

import java.util.List;

public class Kickstarter {

	public static void main(String[] args) {
		QuoteStorage quoteStorage = new QuoteStorage();
		ConsolePrinter.println(quoteStorage.getRandomQuote());

		// show all categories with index
		CategoryStorage categoryStorage = new CategoryStorage();
		// ConsolePrinter.println(categoryStorage);

		List<String> categories = categoryStorage.getAllCategories();
		ConsolePrinter.println(categories);
		// ConsolePrinter.printlnListWithIndexes(categories);

		// CategoriesPrinter cp cs

		// CS => LIst<String> => List<Category>

		/*
		 * for (int i = 0; i < categories.size(); i++) {
		 * ConsolePrinter.println(i + " : " + categories.get(i)); }
		 */

		// ask use to select 1
		// read user input
		// show selected category
	}
}
