package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.model.UserSettings;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.ProjectManager;

public class UserManager {
	private ConsolePrinter consolePrinter;
	private CategoryStorage categoryStorage;
	private ConsoleScanner consoleScanner;
	private Kickstarter kickStarter;

	public UserManager(ConsolePrinter consolePrinter, ConsoleScanner consoleScanner, CategoryStorage categoryStorage,
			Kickstarter kickstarter) {
		this.consolePrinter = consolePrinter;
		this.categoryStorage = categoryStorage;
		this.consoleScanner = consoleScanner;
		this.setKickStarter(kickstarter);
	}
	
	
	
	public void generateMenu(User u){
		
		int selectedOption = 0;
		while(selectedOption == 0){
			selectedOption = chooseProject(kickStarter.getProjectManager(), chooseCategory(u));
		};
		
	}
	

	
	
	public Category chooseCategory(User u) {
		int selectedCategory = 0;
		while (selectedCategory == 0){
			consolePrinter.print(categoryStorage.getCategories());
			consolePrinter.println("Please select category (0 for exit): ");
			selectedCategory = consoleScanner.getInt();

			if (selectedCategory < 0 || selectedCategory > categoryStorage.size()) {
				consolePrinter.println("Please, enter the number between 1 and " + categoryStorage.size());
				continue;
			} else if (selectedCategory != 0) {
				consolePrinter.println("[You selected category number " + selectedCategory + "]");
				u.setSettings(new UserSettings(categoryStorage.getCategoryById(selectedCategory)));
			} else {
				consolePrinter.println("You entered 0. See you soon");
			}
		} 
		return u.getSettings().getCategory();
	}
	
	public int chooseProject(ProjectManager projectManager,Category cat){
		int selectedProject = 0;
		
		do {
			consolePrinter.showProjectList(cat, projectManager);
			consolePrinter.println("Please select project (0 for exit): ");
			selectedProject = consoleScanner.getInt();

			if (selectedProject < 0 || selectedProject > projectManager.getProjectsByCategory(cat).size()) {
				consolePrinter.println("Please, enter the number between 1 and " + categoryStorage.size()+1);
				continue;
			} else if (selectedProject != 0) {
				consolePrinter.println("You selected project: " + projectManager.getProjectsByCategory(cat).get(selectedProject-1).getProjectName());
				consolePrinter.printFullProjectInfo(projectManager.getProjectsByCategory(cat).get(selectedProject-1));
			} else {
				consolePrinter.println("Exit [Choose Project]");
			}
		} while (selectedProject != 0);
	
		return selectedProject;
	}
	
	
	public Kickstarter getKickStarter() {
		return kickStarter;
	}

	public void setKickStarter(Kickstarter kickStarter) {
		this.kickStarter = kickStarter;
	}
}
