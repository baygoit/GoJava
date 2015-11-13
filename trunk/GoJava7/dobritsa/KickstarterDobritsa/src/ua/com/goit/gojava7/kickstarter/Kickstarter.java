package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.QuoteManager;
import ua.com.goit.gojava7.kickstarter.manager.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class Kickstarter {
	private CategoryStorage categoryStorage;

	private ConsoleInspector consoleInspector;

	private ProjectManager projectManager;
	private QuoteManager quoteManager;
	private CategoryManager categoryManager;

	public Kickstarter(ConsoleInspector consoleInspector, CategoryManager categoryManager, QuoteManager quoteManager) {

		this.consoleInspector = consoleInspector;

		this.quoteManager = quoteManager;
		this.categoryManager = categoryManager;
	}

	public void run() {
		int SHIFT_ONE = 1;
		quoteManager.printRandomQuote();
		
		//CategoryManager categoryManager = new CategoryManager();

		while (true) {
			Integer selectedCategory = categoryManager.chooseCategory();
			while (selectedCategory != 0) {
				Integer selectedProject = categoryManager
						.chooseProject(selectedCategory);
				if (selectedProject != null) {
					//projectManager = new ProjectManager(selectedCategory, selectedProject);
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
