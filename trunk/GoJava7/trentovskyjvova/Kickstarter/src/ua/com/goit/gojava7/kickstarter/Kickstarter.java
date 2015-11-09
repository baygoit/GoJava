package ua.com.goit.gojava7.kickstarter;

import java.io.IOException;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleReader;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

public class Kickstarter {
	private QuoteStorage quoteStorage;
	private CategoryStorage categoryStorage;
	private ProjectStorage projectStorage;
	
	private ConsolePrinter consolePrinter;
	private ConsoleReader consoleReader;

	public Kickstarter(ConsolePrinter consolePrinter, ConsoleReader consoleReader, QuoteStorage quoteStorage,
			CategoryStorage categoryStorage, ProjectStorage projectStorage) {

		this.consolePrinter = consolePrinter;
		this.consoleReader = consoleReader;

		this.quoteStorage = quoteStorage;
		this.categoryStorage = categoryStorage;
		this.projectStorage = projectStorage;
	}
	
	public void runKickstarter(){
		consolePrinter.print(quoteStorage.getRandomQuote());
		
		List<Category> categories = categoryStorage.getAllCategories();
		consolePrinter.print(categories);

		List<Project> projects = null;

		consolePrinter.print(0 + " : Exit from application");
		consolePrinter.print("Select a category");

		int userPositionLevel = 0;
		int userChoise = 0;
		Category selected = null;
		boolean notExit = true;

		while (notExit) {
			try {
				userChoise = consoleReader.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (userChoise == 0) {
				if (userPositionLevel == 0) {
					notExit = false;
					continue;
				} else {
					userPositionLevel--;
				}
			} else if (userPositionLevel == 0 && (userChoise < 0 || userChoise > categories.size())) {
				consolePrinter.print("Please, enter the number between 0 and " + categories.size());
				continue;
			} else if (userPositionLevel == 1 && (userChoise < 0 || userChoise > projects.size())) {
				consolePrinter.print("Please, enter the number between 0 and " + projects.size());
				continue;
			} else {
				userPositionLevel++;
				userChoise--;
			}

			if (userPositionLevel == 0) {
				selected = null;
				
				consolePrinter.print("You selected main menu");
				consolePrinter.print(categories);
				
				consolePrinter.print(0 + " : Exit from application");
				consolePrinter.print("Select a category");
				
			} else if (userPositionLevel == 1) {
				if (selected == null){
					selected = categories.get(userChoise);
				}
				
				consolePrinter.print("You selected '" + selected.getName() + "' category");
				
				projects = projectStorage.getProgects(selected);
				consolePrinter.printProjects(projects);
								
				consolePrinter.print(0 + " : main menu");
				consolePrinter.print("Select a project");
		
			} else if (userPositionLevel == 2) {
				Project project = projects.get(userChoise);
				
				consolePrinter.print("You selected '" + project.getName() + "' project");
				consolePrinter.print(project.getAllDetails());
				
				consolePrinter.print(0 + " : to project list");
			}

		}
	}
	
	public void shutdown() {
		try {
			consoleReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
