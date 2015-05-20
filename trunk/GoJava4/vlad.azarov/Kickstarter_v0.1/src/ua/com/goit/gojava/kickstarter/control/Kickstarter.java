package ua.com.goit.gojava.kickstarter.control;

import java.util.ArrayList;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.view.ConsolePrinter;

public class Kickstarter {
    
    QuotesControl quotesControl = new QuotesControl();
    CategoriesControl categoriesControl = new CategoriesControl(new ConsolePrinter());
    InputControl inputControl = new InputControl();

    public void run() {

	boolean isExit = false;
	while (!isExit) {
	    quotesControl.callToShowQuoteMenu();
	    categoriesControl.showCategories();

	    System.out.print("Choose category or print 0 to exit: ");

	    int userInput = inputControl.readUserInput();
	    ArrayList<Category> categories = categoriesControl.getCategories();
	    if (userInput == 0) {
		isExit = true;
	    } else if (userInput > 0 && userInput <= categories.size()) {
		categoriesControl.showCategoryMenu(categories.get(userInput - 1));
	    } else {
		System.out.println("No such category.");
	    }
	}
    }
}
