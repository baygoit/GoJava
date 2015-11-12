package ua.com.goit.gojava7.kickstarter.manager;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class CategoryManager {
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private ConsoleInspector consoleInspector = new ConsoleInspector();
	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 1;
	CategoryStorage categoryStorage;
	Integer selectedProject = -1;
	Integer selectedCategory = -1;
	List<Category> categories;
	
public CategoryManager(List<Category> categories) {
		this.categories = categories;		
	}

	public Integer chooseProject(Category category) {		
		consolePrinter.print(BORDER);
		//consolePrinter.print("Current category: " + categoryStorage.get(categoryNumber - SHIFT_ONE).getName());
		//categoryStorage.get(categoryNumber - SHIFT_ONE);
		consolePrinter.print("List of projects:");
		consolePrinter.printProjects(category.getAll());
		consolePrinter.print("\nChoose a project by number (first to choose another category): ");
		selectedProject = consoleInspector.getCorrectInt(FIRST, category.size());		
		return selectedProject;
	}
	
	public Integer chooseCategory() {
		this.categories = categories;
		consolePrinter.print(BORDER);
		consolePrinter.print("\nList of categories:");
		
		consolePrinter.printCategories(categories);
		consolePrinter.print("\nChoose a category by number (0 for exit): ");
		selectedCategory = consoleInspector.getCorrectInt(FIRST, categories.size());
		if (selectedCategory == 0) {
			consoleInspector.close();
			consolePrinter.print("See you soon!");
			System.exit(0);
		}
		return selectedCategory;
	}

}
