package kickstarter.view;

import kickstarter.control.Kickstarter;
import kickstarter.printer.Printer;
import kickstarter.reader.Reader;

public class PageNavigation {

    private ProjectsViewer projectsViewer;
    private QuotesViewer quotesViewer;
    private CategoriesViewer categoriesViewer;
    private Printer printer;
    private Reader reader;

    public PageNavigation(Printer printer, Reader reader) {
	this.printer = printer;
	this.reader = reader;
	projectsViewer = new ProjectsViewer(printer);
	quotesViewer = new QuotesViewer(printer);
	categoriesViewer = new CategoriesViewer(printer);
    }

    public void navigate(int userInput) {

	//projectsViewer.showAllProjectsOfCategory(categoryName);
	
	boolean isExit = false;
	while (isExit != true) {
	    
	    //userInput = reader.readUserInput();
	    
	    int userInputForCategories = userInput;
	    int userInputForProjects;

	    if (userInputForCategories == 1) {
		projectsViewer.showAllProjectsOfCategory("TECHNOLOGY");
		printer.print("\n\t Choose the project or 0 to previous menu: ");
		userInputForProjects = reader.readUserInput();
		switch (userInputForProjects) {
		case 1:
		    projectsViewer.showDetailProject("TECHNOLOGY", "SNAP");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 2:
		    projectsViewer.showDetailProject("TECHNOLOGY", "HYDAWAY");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 3:
		    projectsViewer.showDetailProject("TECHNOLOGY", "DASH 4.0 WALLET");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 4:
		    projectsViewer.showDetailProject("TECHNOLOGY",
			    "USB CHARGEDOUBLER");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 0:
		    break;
		}

	    } else if (userInputForCategories == 2) {
		projectsViewer.showAllProjectsOfCategory("DESIGN");
		printer.print("\n\t Choose the project or 0 to previous menu: ");
		userInputForProjects = reader.readUserInput();
		switch (userInputForProjects) {
		case 1:
		    projectsViewer.showDetailProject("DESIGN", "FIREFLY HAND");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 2:
		    projectsViewer.showDetailProject("DESIGN", "CUBIT");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 3:
		    projectsViewer.showDetailProject("DESIGN", "NOKI");
		    printer.print("\n\t Enter 0 to previous menu: ");
		    break;
		case 0:
		    break;
		
		}
	    
	    } else if (userInputForCategories == 0) {
		break;
	    }
	}
    }
    
    

}
