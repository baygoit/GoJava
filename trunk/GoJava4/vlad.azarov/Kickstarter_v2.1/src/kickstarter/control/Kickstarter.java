package kickstarter.control;

import kickstarter.printer.Printer;
import kickstarter.reader.Reader;
import kickstarter.repos.CategoriesRepo;
import kickstarter.repos.ProjectsRepo;
import kickstarter.view.CategoriesViewer;
import kickstarter.view.ProjectsViewer;
import kickstarter.view.QuotesViewer;

public class Kickstarter {

    private Reader reader;
    private Printer printer;
    
    private QuotesViewer quotesViewer;
    private CategoriesViewer categoriesViewer;
    private ProjectsViewer projectsViewer;
    private CategoriesRepo categoriesRepo;
    private ProjectsRepo projectsRepo;

    public Kickstarter(Reader reader, Printer printer) {
	this.reader = reader;
	this.printer = printer;
	quotesViewer = new QuotesViewer(printer);
	categoriesViewer = new CategoriesViewer(printer);
	projectsViewer = new ProjectsViewer(printer);
	categoriesRepo = new CategoriesRepo();
	projectsRepo = new ProjectsRepo();
    }

    public void run() {

	greeting();
	quotesViewer.showQuoteMenu();
	
	categoriesViewer.showCategoriesMenu();
	
	projectsViewer.showAllProjectsOfCategory(categoriesRepo.getCategory("TECHNOLOGY"));
	projectsViewer.showAllProjectsOfCategory(categoriesRepo.getCategory("DESIGN"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("TECHNOLOGY"), projectsRepo.getProject("SNAP"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("TECHNOLOGY"), projectsRepo.getProject("HYDAWAY"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("TECHNOLOGY"), projectsRepo.getProject("DASH 4.0 WALLET"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("TECHNOLOGY"), projectsRepo.getProject("USB CHARGEDOUBLER"));
	
	projectsViewer.showDetailProject(categoriesRepo.getCategory("DESIGN"), projectsRepo.getProject("FIREFLY HAND"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("DESIGN"), projectsRepo.getProject("CUBIT"));
	projectsViewer.showDetailProject(categoriesRepo.getCategory("DESIGN"), projectsRepo.getProject("NOKI"));
//	boolean isExit = false;
//	int userInput = -1;
//
//	while (!isExit) {
//	    if (userInput == 0) {
//		isExit = true;
//		farewell();
//	    } else {
//		userInput = reader.readUserInput();
//	    }
//	}
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
