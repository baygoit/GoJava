package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ConsolePrinter consolePrinter;
	private ConsoleReader consoleReader;
	
	public Kickstarter(ConsoleReader consoleReader, 
			ConsolePrinter consolePrinter, QuoteStorage quoteStorage, 
			CategoryStorage categoryStorage) {
		
		this.consoleReader = consoleReader;
		this.consolePrinter = consolePrinter;
		this.categoryStorage = categoryStorage;
		this.quoteStorage = quoteStorage;
	}
	
	public void startKickstarter() {
		consolePrinter.print(quoteStorage.getRandomQuote());
		
		showCategoriesMenu();
	}

	void showCategoriesMenu() {
		ArrayList<Category> categories = categoryStorage.getAllCategories();
		int userChoice = 0;
		
		do {
			consolePrinter.print("");
			consolePrinter.printCategories(categories);
			consolePrinter.print("Please select category or type 0 to exit");
			
			try {
				userChoice = ConsoleReader.getUserChoice();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (userChoice < 0 || userChoice > categories.size()) {
				consolePrinter.print("Please enter the number in range from 0 to " 
			+ categories.size());
				continue;
			}
			else if (userChoice != 0) {
				consolePrinter.print("You selected category number " + userChoice);
				Category category = categoryStorage.getCategory(userChoice - 1);
				try {
					showProjectsMenu(category);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				consolePrinter.print("You entered 0. Come again.");
			}
		} while (userChoice != 0);
	}
	
	private void showProjectsMenu(Category category) throws IOException {
		List<Project> projects = new ArrayList<Project>(category.getProjects());
		
		int userChoice = 0;
		do {
			consolePrinter.print("");
			consolePrinter.print(category, projects);
			consolePrinter.print("Please select a project or type 0 to exit");
			
			userChoice = ConsoleReader.getUserChoice();
			
			if (userChoice < 0 || userChoice > projects.size()) {
				consolePrinter.print("Please enter the number in range from 0 to " 
			+ projects.size());
				continue;
			}
			else if (userChoice != 0) {
				consolePrinter.print("You selected project number " + userChoice);
				Project project = projects.get(userChoice - 1);
				showProjectActionsMenu(project);
			} else {
				consolePrinter.print("You entered 0. Getting back to the categories menu.");
			}
		} while (userChoice != 0);
	}

	private void showProjectActionsMenu(Project project) throws IOException {
		List<String> projectActions = new ArrayList<>();
		projectActions.add("Ask a question");
		projectActions.add("Pledge");
		
		int userChoice = 0;
		do {
			consolePrinter.print("");
			consolePrinter.print(project);
			consolePrinter.print("Actions:");
			for (int i = 0; i < projectActions.size(); i++) {
				consolePrinter.print(i + 1 + ". " + projectActions.get(i));
			}
			consolePrinter.print("Please select an action or type 0 "
					+ "to return to the categories menu");
			userChoice = consoleReader.getUserChoice();
			
			if (userChoice < 0 || userChoice > projectActions.size()) {
				consolePrinter.print("Please type the number between 0 and " 
			+ projectActions.size());
				continue;
			} else if (userChoice != 0) {
				String selectedAction = projectActions.get(userChoice - 1).toLowerCase();
				consolePrinter.print("You selected to " + selectedAction);
			} else {
				consolePrinter.print("You entered 0. Getting back to the projects menu.");
			}
		} while (userChoice != 0);
	}
}