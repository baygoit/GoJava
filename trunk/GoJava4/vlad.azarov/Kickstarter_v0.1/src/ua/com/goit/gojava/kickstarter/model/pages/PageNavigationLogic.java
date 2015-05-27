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
		nextPage = new ProjectInfoPage(printer, currentProject, currentCategory);
		printer.println("--------------------------------------------------------------------");
	    } else {
		showErrorPage();
		return currentPage;
	    }
	    
	} else if (currentPage.getPageId().equals(PageId.PROJECT_INFO)) {
	    int projectInfoId = parseStringToInt(userInput);
	    if (projectsRepository.isCurrentProjectExist(projectInfoId,
		    currentCategory)) {
		currentProject = projectsRepository.getProjectByIdAndCategory(
			projectInfoId, currentCategory);
	    }
	    nextPage = new ProjectInfoPage(printer, currentProject, currentCategory);
	    System.out.println("Current page is sgldfhsodpfh : ");
	} else {
	    nextPage = null;
	    System.out.println("userInput=" + userInput);
	    System.out.println("currentPage.getPageId().equals(PageId.CATEGORIES)");
	}
	
	return nextPage;
    }

    public void showErrorPage() {
	new ErrorPage(printer).showPage();
	// printer.printError("DESCRIPTION: THERE IS NO SUCH CATEGORY");
	// printer.printError(""THERE IS NO SUCH PROJECT");
	// System.out.println("");
    }

    private int parseStringToInt(String userInput) {
	try {
	    return Integer.parseInt(userInput);
	} catch (Exception e) {
	    return ERROR_INPUT_CODE;
	}
    }
}
