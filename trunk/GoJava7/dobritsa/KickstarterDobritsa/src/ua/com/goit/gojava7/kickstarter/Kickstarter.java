package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.QuoteManager;

public class Kickstarter {
	private ConsoleInspector consoleInspector;
	private QuoteManager quoteManager;
	private CategoryManager categoryManager;

	public Kickstarter(ConsoleInspector consoleInspector, 
			CategoryManager categoryManager, QuoteManager quoteManager) {
		this.consoleInspector = consoleInspector;
		this.quoteManager = quoteManager;
		this.categoryManager = categoryManager;
	}

	public void run() {
		quoteManager.printRandomQuote();
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
		consoleInspector.close();
	}

}
