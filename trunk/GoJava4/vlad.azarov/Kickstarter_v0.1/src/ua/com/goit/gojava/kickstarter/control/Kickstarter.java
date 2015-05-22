package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.CategoriesPage;
import ua.com.goit.gojava.kickstarter.view.ConsolePrinter;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.ProjectsPage;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class Kickstarter {

    QuotesController quotesController = new QuotesController();
    CategoriesController categoriesController = new CategoriesController(
	    new ConsolePrinter());
    InputController inputController = new InputController();

    public void run() {

	boolean isExit = false;
	while (!isExit) {
	    quotesController.callsShowQuoteMenu();
	    categoriesController.showCategories();
	    System.out.print("Select a category or enter \"0\" to exit: ");
	    int userInput = inputController.readUserInput();
	    ArrayList<Category> categories = categoriesController
		    .getCategories();
	    
//	    System.out.println("TEST" + categories.get(1));
//	    System.out.println("TEST2 ");
//	    categoriesController.showCategoryMenu1(categories.get(userInput - 1));
//	    CategoriesPage cp = new CategoriesPage(printer);
	    
	    if (userInput == 0) {
		isExit = true;
	    } else if (userInput > 0 && userInput <= categories.size()) {
		categoriesController.showCategoryMenu1(categories
			.get(userInput - 1));
	    } else {
		System.out.println("There is no such category.");
	    }
	}
    }
}
