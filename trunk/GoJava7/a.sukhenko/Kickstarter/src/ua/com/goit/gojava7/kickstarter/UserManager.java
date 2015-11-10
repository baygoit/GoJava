package ua.com.goit.gojava7.kickstarter;

import ua.com.goit.gojava7.kickstarter.console.ConsolePrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.model.User;
import ua.com.goit.gojava7.kickstarter.model.UserSettings;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;

public class UserManager {
	private ConsolePrinter consolePrinter;
	private CategoryStorage categoryStorage;
	private ConsoleScanner consoleScanner;
	
	public UserManager(ConsolePrinter consolePrinter,ConsoleScanner consoleScanner,CategoryStorage categoryStorage) {
		this.consolePrinter = consolePrinter;
		this.categoryStorage = categoryStorage;
		this.consoleScanner = consoleScanner;
	}
	
	public void chooseCategory(User u){
		int selectedCategory;
		do {
			consolePrinter.print(categoryStorage.getCategories());
			consolePrinter.println("Please select category (0 for exit): ");
			selectedCategory = consoleScanner.getInt();

			if (selectedCategory < 0 || selectedCategory > categoryStorage.size()) {
				consolePrinter.println("Please, enter the number between 1 and " + categoryStorage.size());
				continue;
			} else if (selectedCategory != 0) {
				consolePrinter.println("You selected category number " + selectedCategory);
				consolePrinter.printCategory(categoryStorage.getCategoryById(selectedCategory));
			} else {
				consolePrinter.println("You entered 0. See you soon");
			}
		} while(selectedCategory != 0 );
		
		if(selectedCategory != 0){
		u.setSettings(new UserSettings(categoryStorage.getCategoryById(selectedCategory)));
		}
	}
}
