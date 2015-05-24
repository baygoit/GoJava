package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.pages.*;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class Kickstarter {
	
	private final static int DEFAULT_INPUT = -1;
	
	Reader reader;  
	Printer printer;

    PageId currentPage;
    PageNavigationLogic pageNavigationLogic;
    
    public Kickstarter(Reader reader, Printer printer) {
    	this.reader = reader;  
    	this.printer = printer;
    	currentPage = PageId.HOME;
    	pageNavigationLogic = new PageNavigationLogic();    	
	}

    public void run() {
	
	boolean isExit = false;
	int userInput = DEFAULT_INPUT;
	Page page = new HomePage(printer);
	while (!isExit) {
		if (userInput == DEFAULT_INPUT){
			page.showPage();
			userInput = reader.readUserInput();
		}
		else if (userInput == 0){
			isExit = true;
			printer.println("Goodbye! Have a nice day!");
		}
		else {
			page = new ErrorPage(printer);
			page.showPage();
		}
		userInput = pageNavigationLogic.parseUserInput(page.getPageId(), userInput);		
		
	    //break;
	}
    }
}
