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

	private Integer categoryNumber = null;
	private Integer projectNumber = null;
	private List<Category> categories;
	private String BORDER = "\n________________________________________________________";
	private int shiftOne = 1;

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
		categoryNumber = chooseCategory();
		projectNumber = chooseProject(categoryNumber);
		viewProject(projectNumber);
	}

	public Integer chooseCategory() {
		consolePrinter.print(BORDER);
		consolePrinter.print("\nList of categories:");
		consolePrinter.printCategories(categories);
		consolePrinter.print("\nChoose a category by number (0 for exit): ");
		categoryNumber = consoleInspector.getCorrectInt(categoryStorage.size());
		if (categoryNumber == 0) {
			consoleInspector.close();
			consolePrinter.print("See you soon!");
			System.exit(0);
		}

		return categoryNumber;
	}

	public Integer chooseProject(Integer categoryNumber) {
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category: " + categoryStorage.get(categoryNumber - shiftOne).getName());
		categoryStorage.get(categoryNumber - shiftOne);
		consolePrinter.print("List of projects:");
		consolePrinter.printProjects(categoryStorage.get(categoryNumber - shiftOne).get());
		consolePrinter.print("\nChoose a project by number (0 to choose another category): ");
		projectNumber = consoleInspector.getCorrectInt(categoryStorage.get(categoryNumber - shiftOne).size());
		if (projectNumber == 0) {
			chooseProject(chooseCategory());
		}
		return projectNumber - shiftOne;
	}

	private void viewProject(Integer projectNumber) {
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category: " + categoryStorage.get(categoryNumber - shiftOne).getName());
		consolePrinter.print("Current project: #" + (projectNumber + shiftOne) + "\n");
		Project project = new Project();
		project = categoryStorage.get(categoryNumber - shiftOne).get(projectNumber);
		consolePrinter.printFull(project);
		consolePrinter.print("\nType 0 to choose another project");
		while (true) {
			if (consoleInspector.getCorrectInt(0) == 0) {
				viewProject(chooseProject(categoryNumber));
			}
			consolePrinter.print(BORDER);
		}

	}

	public void shutdown() {
		consoleInspector.close();
	}

}
