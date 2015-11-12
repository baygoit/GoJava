package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.manager.CategoryManager;
import ua.com.goit.gojava7.kickstarter.manager.ProjectManager;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;

	private Integer selectedCategory = -1;
	private Integer selectedProject = -1;
	//private List<Category> categories;
	private int SHIFT_ONE = 1;
		
	private ProjectManager projectManager;
	private CategoryManager categoryManager;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleInspector consoleInspector, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());
		List<Category> categories = categoryStorage.getAll();
		categoryManager = new CategoryManager(categories);		
		
		while (selectedCategory != 0){
			selectedCategory = categoryManager.chooseCategory();
			while (selectedCategory != 0) {
				selectedProject = categoryManager.chooseProject(categoryStorage.get(selectedCategory - SHIFT_ONE));
				if(selectedProject != 0) {
					projectManager = new ProjectManager(categoryStorage.get(selectedCategory - SHIFT_ONE).get(selectedProject - SHIFT_ONE));
					projectManager.viewProject();					
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
