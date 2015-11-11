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
			String categoryTitle = categoryManager.getCategorieByNumber(categoryNumber).getTitle();
			consolePrint.selectedCategoryInformer(categoryTitle);
			consolePrint.categorysProjectsView(projectManager.getProjectsForCategory(categoryTitle));
			consolePrint.exitInformer();
			projectSelector(categoryNumber, categoryTitle);
		}
	}

	public static void projectSelector(int categoryNumber, String categoryTitle) {
		consolePrint.projectSelectionInform();
		consolePrint.exitInformer();
		projectManager.getProjectsForCategory(categoryTitle);
		consolePrint.viewSelectedCategoryProjects(projectManager.getProjectsForCategory(categoryTitle));
		while (true) {
			int projectNumber = UserConsoleInputReader.read();
			if (projectNumber == EXIT_SIGN) {
				categorySelector();
			} else {
				String title = projectManager.getProject(categoryTitle, projectNumber).getTitle();
				consolePrint.choosenProjectTitleInform(title);
				consolePrint.singleCategorysProjectsView(projectManager.getProject(categoryTitle, projectNumber));
				consolePrint.posobilitiesInfirm();
				int selectedAction = UserConsoleInputReader.read();
				int payChoise = 200;
				if (selectedAction == payChoise) {
					ps.makePayment(projectNumber, categoryNumber, categoryTitle);
				} else {
					projectSelector(categoryNumber, categoryTitle);
				}
			}

		}

	}
}