package ua.com.goit.gojava7.kickstarter;

import java.io.FileNotFoundException;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;

import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class KickstarterRunner {

	public static void main(String[] args) throws FileNotFoundException { //
		ConsoleScanner consoleScanner = new ConsoleScanner();

		QuotePrinter quotetPrinter = new QuotePrinter();
		ProjectPrinter projectPrinter = new ProjectPrinter();
		CategoryPrinter categoryPrinter = new CategoryPrinter();

		QuoteStorage quoteStorage = new QuoteStorage("D:/1/Quotes.txt");
		
		CategoryStorage categoryStorage= new CategoryStorage();
				categoryStorage.initCategories("D:/1/CategoryMusic.txt");
				categoryStorage.initCategories("D:/1/CategoryFood.txt");
				categoryStorage.initCategories("D:/1/CategoryDances.txt");
		
		Kickstarter kickstarter = new Kickstarter(consoleScanner, quotetPrinter, projectPrinter, categoryPrinter,
				quoteStorage, categoryStorage);

		kickstarter.run();
		kickstarter.shutdown();
	}
}
