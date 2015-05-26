package ua.com.goit.gojava.kickstarter.model.pages;

import ua.com.goit.gojava.kickstarter.model.Category;
import ua.com.goit.gojava.kickstarter.model.Project;
import ua.com.goit.gojava.kickstarter.model.ProjectsRepository;
import ua.com.goit.gojava.kickstarter.view.Printer;

public class PageNavigationLogic {

    public final static int ERROR_INPUT_CODE = -1;

    Printer printer;
    ProjectsRepository projectsRepository;
    Category currentCategory;
    Project currentProject;

    public PageNavigationLogic(Printer printer) {
	this.printer = printer;
	projectsRepository = new ProjectsRepository();
    }

    public Page defineNextPage(Page currentPage, String userInput) {
	Page nextPage;
	// System.out.println("Category.values().length="+Category.values().length);
	// System.out.println("userInput="+userInput);
	// System.out.println("((currentPage.getPageId().equals(PageId.HOME) && (userInput > 0 && userInput <= Category.values().length)))"+((currentPage.getPageId().equals(PageId.HOME)
	// && (userInput > 0 && userInput <= Category.values().length))));
	if (userInput.equals("0")) {
	    nextPage = new CategoriesPage(printer);

	    
	} else if (currentPage.getPageId().equals(PageId.CATEGORIES)) {
	    int categoryId = parseStringToInt(userInput) - 1;
	    if (categoryId >= 0 && categoryId < Category.values().length) {
		currentCategory = Category.values()[categoryId];
		nextPage = new ProjectsPage(printer, currentCategory);
		printer.println("--------------------------------------------------------------------");
	    } else {
		showErrorPage();
		return currentPage;
	    }
	} else if (currentPage.getPageId().equals(PageId.PROJECTS)) {
	    int projectId = parseStringToInt(userInput);
	    if (projectsRepository.isCurrentProjectExist(projectId,
		    currentCategory)) {
		currentProject = projectsRepository.getProjectByIdAndCategory(
			projectId, currentCategory);
		nextPage = new ProjectInfoPage(printer, currentProject);
		System.out.println("Current page is ProjectPage : ");
	    } else {
		showErrorPage();
		return currentPage;
	    }
	} else if (currentPage.getPageId().equals(PageId.PROJECT_INFO)) {
	    // if ()
	    //
	    nextPage = new ProjectInfoPage(printer, currentProject);
	} else {
	    nextPage = null;
	    System.out.println("userInput=" + userInput);
	    System.out.println("currentPage.getPageId().equals(PageId.HOME)");
	}
	return nextPage;
    }

    public void showErrorPage() {
	new ErrorPage(printer).showPage();
	//printer.printError("DESCRIPTION: THERE IS NO SUCH CATEGORY");
	//printer.printError(""THERE IS NO SUCH PROJECT");
	//System.out.println("");
    }

    private int parseStringToInt(String userInput) {
	try {
	    return Integer.parseInt(userInput);
	} catch (Exception e) {
	    return ERROR_INPUT_CODE;
	}
    }
}
