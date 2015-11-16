package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;

	private ConsolePrinter consolePrinter;
	private ConsoleScanner consoleScanner;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner,
			QuoteStorage quoteStorage, CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.consoleScanner = consoleScanner;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
	}

	/**
	 * You should use {@link #shutdown()} after you finished with {@link Kickstarter}
	 */
	public void run() {
		consolePrinter.print(quoteStorage.getRandomQuote());

		showCategoriesMenu();
	}

	void showCategoriesMenu() {
		List<Category> categories = categoryStorage.getAllCategories();

		int selectedCategoryIndex;
		do {
			consolePrinter.print("");
			consolePrinter.print(categories);
			consolePrinter.print("Please select a category (0 for exit): ");
			selectedCategoryIndex = consoleScanner.getInt();

			if (selectedCategoryIndex < 0 || selectedCategoryIndex > categories.size()) {
				consolePrinter.print("Please, enter the number between 0 and " + categories.size());
				continue;
			} else if (selectedCategoryIndex != 0) {
				consolePrinter.print("You selected the category number " + selectedCategoryIndex);
				Category selectedCategory = categories.get(selectedCategoryIndex - 1);
				showProjectsMenu(selectedCategory);
			} else {
				consolePrinter.print("You entered 0. Bye.");
			}
		} while (selectedCategoryIndex != 0);
	}

	void showProjectsMenu(Category selectedCategory) {
		List<Project> projects = new ArrayList<Project>(selectedCategory.getProjects());

		int selectedProjectIndex;
		do {
			consolePrinter.print("");
			consolePrinter.printCategoryWithProjects(selectedCategory);
			consolePrinter.print("Please select a project (0 for exit): ");
			selectedProjectIndex = consoleScanner.getInt();

			if (selectedProjectIndex < 0 || selectedProjectIndex > projects.size()) {
				consolePrinter.print("Please, enter the number between 0 and " + projects.size());
				continue;
			} else if (selectedProjectIndex != 0) {
				consolePrinter.print("You selected the project number " + selectedProjectIndex);
				Project selectedProject = projects.get(selectedProjectIndex - 1);
				showProjectActionsMenu(selectedProject);
			} else {
				consolePrinter.print("You entered 0. Go up.");
			}
		} while (selectedProjectIndex != 0);
	}

	void showProjectActionsMenu(Project selectedProject) {
		List<String> projectActions = new ArrayList<String>();
		projectActions.add("Ask a question");
		projectActions.add("Invest");

		int selectedProjectActionIndex;
		do {
			consolePrinter.print("");
			consolePrinter.print(selectedProject);
			consolePrinter.print("Actions:");
			for (int i = 0; i < projectActions.size(); i++) {
				consolePrinter.print("\t" + (i + 1) + " : " + projectActions.get(i));
			}
			consolePrinter.print("Please select an action (0 for exit): ");
			selectedProjectActionIndex = consoleScanner.getInt();

			if (selectedProjectActionIndex < 0 || selectedProjectActionIndex > projectActions.size()) {
				consolePrinter.print("Please, enter the number between 0 and " + projectActions.size());
				continue;
			} else if (selectedProjectActionIndex != 0) {
				consolePrinter.print("You selected the project number " + selectedProjectActionIndex);
				String selectedProjectAction = projectActions.get(selectedProjectActionIndex - 1);
				consolePrinter.print("You selected : " + selectedProjectAction);
			} else {
				consolePrinter.print("You entered 0. Go up.");
			}
		} while (selectedProjectActionIndex != 0);
	}

	/**
	 * Should be run before GC
	 */
	public void shutdown() {
		consoleScanner.close();
	}

}
