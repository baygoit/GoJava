package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;
import ua.com.goit.gojava.kickstarter.view.ConsoleInputReader;
import ua.com.goit.gojava.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class Kickstarter {

    QuotesController quotesController = new QuotesController();
    CategoriesController categoriesController = new CategoriesController(
	    new ConsolePrinter());
    Reader reader = new ConsoleInputReader();

    public void run() {
	
	boolean exit = false;
	while (!exit) {
	    quotesController.callsShowQuoteMenu();
	    categoriesController.showExistingCategories();
	    
	    System.out.println("Select a category or enter \"0\" to exit: ");
	    int userInput = reader.readUserInput();
	    System.out.println("You entered " + userInput);
	    
	    categoriesController.showChoosenCategory(userInput);
	    
	    break;
	}
	
	

//	boolean isExit = false;
//	while (!isExit) {
//	    quotesController.callsShowQuoteMenu();
//	    categoriesController.showCategories();
//	    System.out.print("Select a category or enter \"0\" to exit: ");
//	    int userInput = inputReader.readUserInput();
//	    ArrayList<Category> categories = categoriesController
//		    .getCategories();
//
//	    if (userInput == 0) {
//		isExit = true;
//	    } else if (userInput > 0 && userInput <= categories.size()) {
//		categoriesController.showCategoryMenu1(categories
//			.get(userInput - 1));
//	    } else {
//		System.out.println("There is no such category.");
//	    }
//	}
    }
}
