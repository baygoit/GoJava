package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;
import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.ConsolePrinter;

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
