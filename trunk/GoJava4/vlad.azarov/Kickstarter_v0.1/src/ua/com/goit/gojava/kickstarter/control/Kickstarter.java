package ua.com.goit.gojava.kickstarter.control;

import ua.com.goit.gojava.kickstarter.model.Quote;
import ua.com.goit.gojava.kickstarter.model.QuotesRepository;
import ua.com.goit.gojava.kickstarter.model.pages.Page;
import ua.com.goit.gojava.kickstarter.model.pages.PageId;
import ua.com.goit.gojava.kickstarter.model.pages.PageNavigationLogic;
import ua.com.goit.gojava.kickstarter.view.Printer;
import ua.com.goit.gojava.kickstarter.view.QuotesViewer;
import ua.com.goit.gojava.kickstarter.view.Reader;

public class Kickstarter {

    Reader reader;
    Printer printer;
    Quote quote;
    QuotesViewer quotesViewer;
    PageId currentPage;
    PageNavigationLogic pageNavigationLogic;
    QuotesRepository quotesRepository;

    public Kickstarter(Reader reader, Printer printer) {
	this.reader = reader;
	this.printer = printer;
	currentPage = PageId.CATEGORIES;
	pageNavigationLogic = new PageNavigationLogic(printer);
	quotesViewer = new QuotesViewer(printer);
	quotesRepository = new QuotesRepository();
    }

    public void run() {
	boolean isExit = false;
	String userInput = "0";
	Page currentPage = null;
	
	System.out.print("====================================================================\n");
	System.out.println("                    WELCOME TO KICKSTARTER v.2.0.");
	System.out.println("--------------------------------------------------------------------");
	
	quotesViewer.showQuoteMenu(quotesRepository.getRandomQuote());
	
	while (!isExit) {
	    if (userInput.toLowerCase().equals("bye")) {
		isExit = true;
		printer.println("--------------------------------------------------------------------");
		printer.println("                     GOODBYE! HAVE A NICE DAY!                      ");
		printer.println("====================================================================");
	    } else {
		currentPage = pageNavigationLogic.defineNextPage(currentPage,
			userInput);
		currentPage.showPage();
		userInput = reader.readUserInput();
	    }
	    // break;
	}
    }
}
