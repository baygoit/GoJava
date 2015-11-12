package ua.com.goit.gojava7.kickstarter;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsoleInspector;
import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleInspector consoleInspector;

	private Integer selectedCategory = null;
	private Integer selectedProject = null;
	private List<Category> categories;
	private String BORDER = "\n________________________________________________________";
	private int SHIFT_ONE = 1;
	private int FIRST = 0;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleInspector consoleInspector, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());
		categories = categoryStorage.getAll();
		selectedCategory = chooseCategory();
		selectedProject = chooseProject(selectedCategory);
		viewProject(selectedProject);
	}

	public Integer chooseCategory() {
		consolePrinter.print(BORDER);
		consolePrinter.print("\nList of categories:");
		
		consolePrinter.printCategories(categories);
		consolePrinter.print("\nChoose a category by number (0 for exit): ");
		selectedCategory = consoleInspector.getCorrectInt(FIRST, categoryStorage.size());
		if (selectedCategory == 0) {
			consoleInspector.close();
			consolePrinter.print("See you soon!");
			System.exit(0);
		}

		return selectedCategory;
	}

	public Integer chooseProject(Integer selectedCategory) {
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category: " + categoryStorage.get(selectedCategory - SHIFT_ONE).getName());
		categoryStorage.get(selectedCategory - SHIFT_ONE);
		consolePrinter.print("List of projects:");
		consolePrinter.printProjects(categoryStorage.get(selectedCategory - SHIFT_ONE).getAll());
		consolePrinter.print("\nChoose a project by number (first to choose another category): ");
		selectedProject = consoleInspector.getCorrectInt(FIRST, categoryStorage.get(selectedCategory - SHIFT_ONE).size());
		if (selectedProject == 0) {
			chooseProject(chooseCategory());
		}
		return selectedProject;
	}

	private void viewProject(Integer selectedProject) {
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category: " + categoryStorage.get(selectedCategory - SHIFT_ONE).getName());
		consolePrinter.print("Current project: #" + (selectedProject) + "\n");
		Project project = new Project();
		project = categoryStorage.get(selectedCategory - SHIFT_ONE).get(selectedProject - SHIFT_ONE);
		consolePrinter.printFull(project);
		consolePrinter.print("\nType 0 to choose another project");
		while (true) {
			if (consoleInspector.getCorrectInt(FIRST, 0) == 0) {
				viewProject(chooseProject(selectedCategory));
			}
			consolePrinter.print(BORDER);
		}

	}

	public void shutdown() {
		consoleInspector.close();
	}

}
