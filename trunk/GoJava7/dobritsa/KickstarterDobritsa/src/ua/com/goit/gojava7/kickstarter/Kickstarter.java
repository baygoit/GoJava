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

	Integer categoryNumber = null;
	Integer projectNumber = null;
	List<Category> categories;
	String BORDER = "\n________________________________________________________";

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleInspector consoleInspector, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleInspector = consoleInspector;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());
		categories = categoryStorage.get();
		categoryNumber = chooseCategory();
		projectNumber = chooseProject(categoryNumber);
		viewProject(projectNumber);
	}

	public Integer chooseCategory() {
		consolePrinter.print("\nList of categories:");
		consolePrinter.printCategories(categories);
		consolePrinter.print("\nChoose a category by number (0 for exit): ");
		categoryNumber = consoleInspector.getCorrectInt(categoryStorage.size());
		if (categoryNumber == 0) {
			consoleInspector.close();
			consolePrinter.print("See you soon!");
			System.exit(0);
		}
		consolePrinter.print(BORDER);
		consolePrinter.print("Current category: " + categoryStorage.get(categoryNumber - 1).getName());
		categoryStorage.get(categoryNumber);
		return categoryNumber;
	}

	public Integer chooseProject(Integer categoryNumber) {
		consolePrinter.print("List of projects:");
		consolePrinter.printProjects(categoryStorage.get(categoryNumber - 1).get());
		consolePrinter.print("\nChoose a project by number (0 for return to list of categories): ");
		projectNumber = consoleInspector.getCorrectInt(categoryStorage.get(categoryNumber - 1).size());
		if (projectNumber == 0) {
			chooseProject(chooseCategory());
		}
		consolePrinter.print(BORDER);
		consolePrinter.print("Current project number " + projectNumber + ": ");
		return projectNumber - 1;
	}

	private void viewProject(Integer projectNumber) {
		Project project = new Project();
		project = categoryStorage.get(categoryNumber - 1).get(projectNumber);
		consolePrinter.printFull(project);
		while (true) {
			if (consoleInspector.getCorrectInt(0) == 0) {
				viewProject(chooseProject(categoryNumber));
			}
			consolePrinter.print("Type 0 to choose another project");
		}
	}

	public void shutdown() {
		consoleInspector.close();
	}

}
