package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterFlow {
	public static void main(String[] args) {
		ConsolePrinter consolePrinter = new ConsolePrinter();
		ConsoleReader consoleReader = new ConsoleReader();
		QuoteStorage quoteStorage = initQuoteStorage();
		CategoryStorage categoryStorage = initCategoryStorage();
		
		Kickstarter kickstarter = new Kickstarter(consoleReader, consolePrinter,
				quoteStorage, categoryStorage);
		
		try {
			kickstarter.startKickstarter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static CategoryStorage initCategoryStorage() {
		CategoryStorage categoryStorage = new CategoryStorage();
		categoryStorage.addCategory(new Category("Art"));
		categoryStorage.addCategory(new Category("Comics"));
		categoryStorage.addCategory(new Category("Crafts"));
		categoryStorage.addCategory(new Category("Dance"));
		categoryStorage.addCategory(new Category("Design"));
		return categoryStorage;
	}

	private static QuoteStorage initQuoteStorage() {
		QuoteStorage quoteStorage = new QuoteStorage();
		quoteStorage.add(new Quote(
				"No truly great person ever thought themselves so.", "William Hazlitt"));
		quoteStorage.add(new Quote(
				"I always look forward to working with Goldie "
				+ "because she's a great person to work with.", "Kurt Russell"));
		return quoteStorage;	
	}
}
