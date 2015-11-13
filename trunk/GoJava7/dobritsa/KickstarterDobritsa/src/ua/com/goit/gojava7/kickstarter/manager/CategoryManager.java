package ua.com.goit.gojava7.kickstarter.manager;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class CategoryManager {
	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;
	private CategoryStorage categoryStorage;
	
	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 1;
	private Integer selectedProject = -1;
	private Integer selectedCategory = -1;

	public CategoryManager(ConsolePrinter consolePrinter,
			ConsoleInspector consoleInspector, CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;
		this.categoryStorage = categoryStorage;
	}

	public Integer chooseCategory() {	
		consolePrinter.print(BORDER);
		consolePrinter.print("\nList of categories:");
		consolePrinter.printCategories(categoryStorage.getAll());
		consolePrinter.print("\nChoose a category by number (0 for exit): ");
		selectedCategory = consoleInspector.getCorrectInt(FIRST, categoryStorage.size());
		if (selectedCategory == 0) {
			consoleInspector.close();
			consolePrinter.print("See you soon!");
			System.exit(0);
		}
		return selectedCategory;
	}

	public Integer chooseProject(Category category, CategoryStorage categoryStorage) {
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category N: " + (categoryStorage.indexOf(category) + 1)
				+ "(" + category.getName() + ")");		
		consolePrinter.print("List of projects:");
		consolePrinter.printProjects(categoryStorage.get(selectedCategory - SHIFT_ONE).getAll());
		consolePrinter.print("\nChoose a project by number (first to choose another category): ");
		selectedProject = consoleInspector.getCorrectInt(FIRST, 
				categoryStorage.get(selectedCategory - SHIFT_ONE).size());
		return selectedProject;
	}

}
