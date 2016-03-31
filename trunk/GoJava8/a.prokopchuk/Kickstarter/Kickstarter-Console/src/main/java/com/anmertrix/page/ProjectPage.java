package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

public class ProjectPage implements Page {
	
	private ViewPage viewPage;
	private IO io;
	private static final int QUESTION_PAGE = 1;
	private static final int INVESTMENT_PAGE = 2;
	private static final int REWARD_PAGE = 3;
	private static final int PROJECTS_PAGE = 4;
	private static final int CATEGORIES_PAGE = 5;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		this.io = viewPage.getIo();
		
		CategoryDao categoryDao = viewPage.getCategoryDao();
		List<Project> projects = categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		try {
			Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
			io.println(SOLID_LINE);
			io.println(project.getName()); //time
			io.println(SOLID_LINE);
			showSelectedProject(project);
		} catch (Exception e) {
			System.err.println("There is no such project! Select again...");
			e.printStackTrace();
			viewPage.setPage(new ProjectsPage());
			return;
		}
		io.println(SOLID_LINE);
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
			} else if (numberMenuItem == QUESTION_PAGE) {
				viewPage.setPage(new QuestionPage());
			} else if (numberMenuItem == INVESTMENT_PAGE) {
				viewPage.setPage(new InvestmentPage());
			} else if (numberMenuItem == REWARD_PAGE) {
				viewPage.setPage(new RewardPage());
			} else if (numberMenuItem == PROJECTS_PAGE) {
				viewPage.setPage(new ProjectsPage());
			} else if (numberMenuItem == CATEGORIES_PAGE) {
				viewPage.setPage(new CategoriesPage());
			} else {
				io.print("Plese, select right menu item...");
				isExitSelect = true;
			}
		} while (isExitSelect);
	}

	void showSelectedProject(Project project) {
		
		io.println("Description: " + project.getDescription());
		io.println("Required budget: " + project.getRequiredBudget());
		io.println("Gathered budget: " + project.getGatheredBudget());
		io.println("Days left: " + project.getDaysLeft());
		io.println("History: " + project.getHistory());
		io.println("Video URL: " + project.getURL());
		io.println("Question and answer: \n" + project.getQuestionAnswer());
	}
	
	public void showProjectMenu() {
		io.print("1 - Ask a question    " 
				+ "2 - Invest project    "
				+ "3 - Rewards    " 
				+ "4 - Exit to projecs menu    "
				+ "5 - Exit to categories menu    "
				+ "0 - EXIT" 
				+ "\n" 
				+ "Please, select menu item...");
	}
}
