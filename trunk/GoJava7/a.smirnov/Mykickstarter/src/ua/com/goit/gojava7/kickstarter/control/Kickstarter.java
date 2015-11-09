package ua.com.goit.gojava7.kickstarter.control;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoriesStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectsStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuotesStorage;
import ua.com.goit.gojava7.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.view.ConsoleScanner;

public class Kickstarter {

	private static final String SEPARATOR = "**********************************************************************";
	ConsolePrinter consolePrinter;
	ConsoleScanner consoleScanner;
	CategoriesStorage categoriesStorage;
	QuotesStorage quotesStorage;
	ProjectsStorage projectsStorage;

	public Kickstarter(ConsoleScanner consoleScanner, ConsolePrinter consolePrinter,
			CategoriesStorage categoriesStorage, QuotesStorage quotesStorage, ProjectsStorage projectsStorage) {
		this.consoleScanner = consoleScanner;
		this.consolePrinter = consolePrinter;
		this.categoriesStorage = categoriesStorage;
		this.quotesStorage = quotesStorage;
		this.projectsStorage = projectsStorage;
	}

	public void start() {
		selectCategory();
	}

	private void selectCategory() {
		List<Category> categories = categoriesStorage.getListOfSource();
		Category selectedCategory = null;

		int amountOfCategories = categories.size();
		int numberOfSelectedCategory;
		boolean userChoise = true;

		do {
			consolePrinter.print(categories);
			consolePrinter.print(SEPARATOR);
			consolePrinter.print("Please select category (0 for exit): ");
			numberOfSelectedCategory = consoleScanner.getInt();

			if (numberOfSelectedCategory < 0 || numberOfSelectedCategory > amountOfCategories) {
				consolePrinter.print("Please, enter the number between 0 and " + amountOfCategories);
				consolePrinter.print(SEPARATOR);
				continue;
			} else if (numberOfSelectedCategory != 0) {
				consolePrinter.print("You selected category number " + numberOfSelectedCategory);
				selectedCategory = categories.get(numberOfSelectedCategory - 1);
				consolePrinter.print(selectedCategory);
				consolePrinter.print(SEPARATOR);
					
				List<Project> listOfSelectedProjects = projectsStorage.
						selectedProjectsFromCartainCategory(selectedCategory);				
				
				selectProjects(listOfSelectedProjects);
			} else {
				consolePrinter.print("You entered 0. Bye.");
				consolePrinter.print(SEPARATOR);
				userChoise = false;
			}
		} while (userChoise);
	}

	private void selectProjects(List<Project> listOfSelectedProjects) {
		List<Project> projects = listOfSelectedProjects;
		Project selectedProject = null;

		int amountOfPrjects = listOfSelectedProjects.size();
		int numberOfSelectedProject;
		boolean userChoise = true;
		
		do

		{
			consolePrinter.printListOfProjects(listOfSelectedProjects);
			consolePrinter.print(SEPARATOR);
			consolePrinter.print("Please select project (0 - back to list of categories): ");
			numberOfSelectedProject = consoleScanner.getInt();

			if (numberOfSelectedProject < 0 || numberOfSelectedProject > amountOfPrjects) {
				consolePrinter.print("Please, enter the number between 0 and " + amountOfPrjects);
				consolePrinter.print(SEPARATOR);
				continue;
			} else if (numberOfSelectedProject != 0) {
				consolePrinter.print("You selected project number " + numberOfSelectedProject);
				selectedProject = projects.get(numberOfSelectedProject - 1);
				consolePrinter.print(SEPARATOR);
				consolePrinter.printFullInfoProject(selectedProject);
				consolePrinter.print(SEPARATOR);
				
				do {
					consolePrinter.print("Please enter 0 - back to list of projects");
					numberOfSelectedProject = consoleScanner.getInt();
					consolePrinter.print(SEPARATOR);
					
				} while (numberOfSelectedProject != 0);			
				
			} else {
				consolePrinter.print("You entered 0. Back to categories.");
				consolePrinter.print(SEPARATOR);
				userChoise = false;
			}
		} while (userChoise);

	}

	public void shutdown() {
		consoleScanner.close();
	}
}
