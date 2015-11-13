package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;
	
	private ProjectManager projectManager;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleInspector consoleInspector, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		Integer selectedCategory = -1;
		Integer selectedProject = -1;	
		int SHIFT_ONE = 1;	
		
		consolePrinter.print(quoteStorage.getRandomQuote());
		CategoryManager categoryManager = new CategoryManager(consolePrinter, 
				consoleInspector, categoryStorage);					
		
		while (selectedCategory != 0){
			selectedCategory = categoryManager.chooseCategory();
			while (selectedCategory != 0) {
				selectedProject = categoryManager.chooseProject(categoryStorage.get(selectedCategory - SHIFT_ONE), categoryStorage);
				if(selectedProject != 0) {
					projectManager = new ProjectManager(categoryStorage.
							get(selectedCategory - SHIFT_ONE).get(selectedProject - SHIFT_ONE), 
							consolePrinter, consoleInspector);
					projectManager.viewProject(selectedCategory, selectedProject);					
				}else {
					break;
				}			
			}
		}		
	}
		
	public void shutdown() {
		consoleInspector.close();
	}

}
