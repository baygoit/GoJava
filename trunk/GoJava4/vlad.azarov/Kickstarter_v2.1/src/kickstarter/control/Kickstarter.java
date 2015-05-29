package kickstarter.control;

import kickstarter.printer.Printer;
import kickstarter.reader.Reader;
import kickstarter.repos.CategoriesRepo;
import kickstarter.repos.ProjectsRepo;
import kickstarter.view.CategoriesViewer;
import kickstarter.view.PageNavigation;
import kickstarter.view.ProjectsViewer;
import kickstarter.view.QuotesViewer;

public class Kickstarter {
    
    private Printer printer;
    private Reader reader;
    private QuotesViewer quotesViewer;
    private CategoriesViewer categoriesViewer;
    private ProjectsViewer projectsViewer;
    private CategoriesRepo categoriesRepo;
    private ProjectsRepo projectsRepo;
    private PageNavigation pageNavigation;

    public Kickstarter(Reader reader, Printer printer) {
	this.printer = printer;
	this.reader = reader;
	quotesViewer = new QuotesViewer(printer);
	categoriesViewer = new CategoriesViewer(printer);
	projectsViewer = new ProjectsViewer(printer);
	categoriesRepo = new CategoriesRepo();
	projectsRepo = new ProjectsRepo();
	pageNavigation = new PageNavigation(printer, reader);
    }

    public void run() {
	
	int userInput = -1;
	
	greeting();
	quotesViewer.showQuoteMenu();
	categoriesViewer.showCategoriesMenu();
	System.out.print("ENTER: ");
	userInput = reader.readUserInput();
	
	boolean isExit = false;
	while (!isExit) {
	    if (userInput == 0) {
		isExit = true;
		farewell();
	    } else {
		//categoriesViewer.showCategoriesMenu();
		//printer.print("\n\t Choose the category: ");
		pageNavigation.navigate(userInput);
	    }
	}
	
	
	
    }

    public void greeting() {
	printer.println("====================================================================");
	printer.println("                    WELCOME TO KICKSTARTER v.2.1.");
	printer.println("--------------------------------------------------------------------");
    }

    public void farewell() {
	printer.println("--------------------------------------------------------------------");
	printer.println("                     GOODBYE! HAVE A NICE DAY!                      ");
	printer.println("====================================================================");
    }

}
