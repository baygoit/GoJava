package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.pages.Page;
import ua.com.goit.gojava.kickstarter.model.pages.PageId;
import ua.com.goit.gojava.kickstarter.model.pages.PageNavigationLogic;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class Kickstarter {

	Reader reader;
	Printer printer;

	PageId currentPage;
	PageNavigationLogic pageNavigationLogic;

	public Kickstarter(Reader reader, Printer printer) {
		this.reader = reader;
		this.printer = printer;
		currentPage = PageId.HOME;
		pageNavigationLogic = new PageNavigationLogic(printer);
	}

	public void run() {
		boolean isExit = false;
		String userInput = "0";
		Page currentPage = null;
		while (!isExit) {
			if (userInput.toLowerCase().equals("bye")) {
				isExit = true;
				printer.println("Goodbye! Have a nice day!");
			} else {
				currentPage = pageNavigationLogic.defineNextPage(currentPage, userInput);
				currentPage.showPage();
				userInput = reader.readUserInput();
			}
			// break;
		}
	}	
}
