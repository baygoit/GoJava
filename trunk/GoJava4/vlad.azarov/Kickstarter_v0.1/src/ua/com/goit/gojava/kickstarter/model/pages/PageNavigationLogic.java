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
		System.out.println("Category.values().length="+Category.values().length);
		System.out.println("userInput="+userInput);
		//System.out.println("((currentPage.getPageId().equals(PageId.HOME) && (userInput > 0 && userInput <= Category.values().length)))"+((currentPage.getPageId().equals(PageId.HOME) && (userInput > 0 && userInput <= Category.values().length))));
		if (userInput.equals("0")){
			nextPage = new HomePage(printer);
			System.out.println("Current page is HomePage");
		}
		else if (currentPage.getPageId().equals(PageId.HOME)){
			int categoryId = parseStringToInt(userInput)-1;
			if (categoryId >= 0 && categoryId < Category.values().length){
				currentCategory = Category.values()[categoryId];
				nextPage = new CategoryPage(printer, currentCategory);
				System.out.println("Current page is CategoryPage");
			}
			else {
				String message = "There is no such category";
				showErrorPage(message);
				return currentPage;
			}
		}
		else if (currentPage.getPageId().equals(PageId.CATEGORY)){
			int projectId = parseStringToInt(userInput);
			if (projectsRepository.isCurrentProjectExist(projectId, currentCategory)){
				currentProject = projectsRepository.getProjectByIdAndCategory(projectId, currentCategory);
				nextPage = new ProjectPage(printer, currentProject);
				System.out.println("Current page is ProjectPage : " );
			}
			else {
				String message = "There is no such project";
				showErrorPage(message);
				return currentPage;
			}			
		}
		else if (currentPage.getPageId().equals(PageId.PROJECT)){
			//if ()
			//
			nextPage = new ProjectPage(printer, currentProject);
		}
		else {
			nextPage = null;
			System.out.println("userInput="+userInput);
			System.out.println("currentPage.getPageId().equals(PageId.HOME)");
		}
		return nextPage;
	}

	public void showErrorPage(String message) {
		new ErrorPage(printer).showPage();
		printer.println(message);
	}
	
	private int parseStringToInt(String userInput) {
		try {
			return Integer.parseInt(userInput);
		}
		catch (Exception e){
			return ERROR_INPUT_CODE;
		}
	}
}
