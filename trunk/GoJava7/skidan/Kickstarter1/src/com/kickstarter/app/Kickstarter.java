package com.kickstarter.app;



import com.kickstarter.manager.CategoryManager;
import com.kickstarter.manager.PaymentSystem;
import com.kickstarter.manager.ProjectManager;
import com.kickstarter.util.ConsolePrintView;
import com.kickstarter.util.UserConsoleInputReader;

public class Kickstarter {
	static PaymentSystem ps = new PaymentSystem();
	static ConsolePrintView consolePrint = new ConsolePrintView();
	static CategoryManager categoryManager = new CategoryManager();
	static ProjectManager projectManager = new ProjectManager();
	static int EXIT_SIGN = 0;

	public static void main(String[] args) {
		categorySelector();

	}

	public static void categorySelector() {
		consolePrint.allCategoriesView(categoryManager.getAllCategories());
		consolePrint.categorySelectionInform();
		int categoryNumber = UserConsoleInputReader.read();
		if (categoryNumber == EXIT_SIGN) {
			consolePrint.programExitInform();
		} else {
			consolePrint.selectedCategoryInformer(categoryManager.getCategorieByNumber(categoryNumber));
			consolePrint.categorysProjectsView(projectManager
					.getProjectsForCategory(categoryManager.getCategorieByNumber(categoryNumber).getTitle()));
			consolePrint.exitInformer();
			projectSelector(categoryNumber);
		}
	}

	public static void projectSelector(int categoryNumber) {
		consolePrint.projectSelectionInform();
		while (true) {
			int projectNumber = UserConsoleInputReader.read();
			if (projectNumber == EXIT_SIGN) {
				categorySelector();
			} else {
				String categoryTitle = categoryManager.getCategorieByNumber(categoryNumber).getTitle();
                String title = projectManager.getProject(categoryTitle, projectNumber).getTitle();
				consolePrint.choosenProjectTitleInform(title);
				consolePrint.singleCategorysProjectsView(projectManager.getProject(categoryTitle, projectNumber));
                consolePrint.posobilitiesInfirm();
            	int selectedAction = UserConsoleInputReader.read();
            	int payChoise = 200;
            	 if (selectedAction == payChoise) {
            		 ps.makePayment(projectNumber, categoryNumber, categoryTitle);
            	 }else{
            		 projectSelector(categoryNumber);
            	 }
			}


		}

	}
}