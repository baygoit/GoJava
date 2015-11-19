package ua.com.goit.gojava7.kickstarter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.CategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.FileCategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.FileQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.MemoryCategoryReader;
import ua.com.goit.gojava7.kickstarter.dao.MemoryQuoteReader;
import ua.com.goit.gojava7.kickstarter.dao.QuoteReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRunner {

	private static final File QUOTES_FILE = new File("./resources/Quotes.txt");
	private static final File CATEGORIES_FILE = new File("./resources/Category.txt");
	
	private static QuoteReader getQuoteReader(boolean isFromFile) {
		if (!isFromFile) {
			return new MemoryQuoteReader();		
		} else {
			return new FileQuoteReader(QUOTES_FILE);
		}
	}
	
	private static CategoryReader getCategoryReader(boolean isFromFile) {
		if (!isFromFile) {		
			return new MemoryCategoryReader();
		} else {		
			return new FileCategoryReader(CATEGORIES_FILE);			
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		boolean isFromFile = false;
		if (args.length != 0) {
			isFromFile = true;
		}
		QuoteStorage quoteStorage = initQuotes(isFromFile);
		CategoryStorage categoryStorage = initCategories(isFromFile);	
		Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage);
		kickstarter.run();
		kickstarter.shutdown();
	}

	private static QuoteStorage initQuotes(boolean isFromFile) {
		QuoteStorage quoteStorage = new QuoteStorage();
		QuoteReader quoteReader = getQuoteReader(isFromFile);
		List<Quote> quotes = quoteReader.read();
		quoteStorage.setAll(quotes);
		return quoteStorage;
	}
	
	private static CategoryStorage initCategories(boolean isFromFile) {
		CategoryStorage categoryStorage = new CategoryStorage();
		CategoryReader categoryReader = getCategoryReader(isFromFile);
		List<Category> categories = categoryReader.read();
		categoryStorage.setAll(categories);
		return categoryStorage;
	}
}
