package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private ConsoleScanner consoleScanner;
	
	private CategoryManager categoryManager;// = new CategoryManager(consoleScanner);
	private QuoteStorage quoteStorage = new QuoteStorage();
	private QuotePrinter quotePrinter= new QuotePrinter(quoteStorage);

	public Kickstarter(ConsoleScanner consoleScanner) {	
		this.consoleScanner = consoleScanner;
		categoryManager = new CategoryManager(consoleScanner);
	}

	public void run() {
		quotePrinter.printRandomQuote();
		while (true) {
			Integer selectedCategory = categoryManager.chooseCategory();
			while (selectedCategory != 0) {
				Integer selectedProject = categoryManager
						.chooseProject(selectedCategory);
				if (selectedProject != null) {				
					categoryManager.viewProject(selectedCategory, selectedProject);
				} else {
					break;
				}
			}
		}
	}

	public void shutdown() {
		consoleScanner.close();
	}

}
