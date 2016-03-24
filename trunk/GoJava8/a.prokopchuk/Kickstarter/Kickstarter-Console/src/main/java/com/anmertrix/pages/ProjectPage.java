package com.anmertrix.pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Project;

public class ProjectPage implements Page {
	
	ViewPage viewPage;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		List<Project> projects = viewPage.categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		try {
			Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
			viewPage.io.println(SOLID_LINE);
			viewPage.io.println(project.getName());
			viewPage.io.println(SOLID_LINE);
			showSelectedProject(project);
		} catch (Exception e) {
			System.err.println("There is no such project! Select again...");
			e.printStackTrace();
			viewPage.setPage(new ProjectsPage());
			return;
		}
		viewPage.io.println(SOLID_LINE);
		showProjectMenu();
		selectMenuItem();		
	}
	
	private void selectMenuItem() {
		boolean isExitSelect;
		int numberMenuItem;
		do {
			isExitSelect = false;
			numberMenuItem = viewPage.getInputNumber();
			if (numberMenuItem == EXIT_INPUT) {
				viewPage.setPage(new ExitPage());
			} else if (numberMenuItem == 1) {
				viewPage.setPage(new QuestionPage());
			} else if (numberMenuItem == 2) {
				viewPage.setPage(new InvestmentPage());
			} else if (numberMenuItem == 3) {
				viewPage.setPage(new RewardPage());
			} else if (numberMenuItem == 4) {
				viewPage.setPage(new ProjectsPage());
			} else if (numberMenuItem == 5) {
				viewPage.setPage(new CategoriesPage());
			} else {
				viewPage.io.print("Plese, select right menu item...");
				isExitSelect = true;
			}
		} while (isExitSelect);
	}

	void showSelectedProject(Project project) {
		viewPage.io.println("Description: " + project.getDescription());
		viewPage.io.println("Required budget: " + project.getRequiredBudget());
		viewPage.io.println("Gathered budget: " + project.getGatheredBudget());
		viewPage.io.println("Days left: " + project.getDaysLeft());
		viewPage.io.println("History: " + project.getHistory());
		viewPage.io.println("Video URL: " + project.getURL());
		viewPage.io.println("Question and answer: \n" + project.getQuestionAnswer());
	}
	
	public void showProjectMenu() {
		viewPage.io.print("1 - Ask a question    " 
				+ "2 - Invest project    "
				+ "3 - Rewards    " 
				+ "4 - Exit to projecs menu    "
				+ "5 - Exit to categories menu    "
				+ "0 - EXIT" 
				+ "\n" 
				+ "Please, select menu item...");
	}
}
