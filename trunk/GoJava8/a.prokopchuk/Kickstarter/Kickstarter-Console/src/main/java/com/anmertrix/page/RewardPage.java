package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

public class RewardPage implements Page {
	
	private ViewPage viewPage;
	private IO io;
	private static final int REWARD_ITEM_1 = 1;
	private static final int REWARD_ITEM_2 = 2;
	private static final int REWARD_ITEM_3 = 3;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		this.io = viewPage.getIo();
		
		CategoryDao categoryDao = viewPage.getCategoryDao();
		
		List<Project> projects = categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		io.println(SOLID_LINE);
		io.println("Rewards");
		io.println(SOLID_LINE);
		showMenu(project);
		selectReward(project);
		viewPage.setPage(new ProjectPage());
	}
	
	private void selectReward(Project project) {
		boolean isExitSelect;
		do {
			isExitSelect = false;
			int numberItem = viewPage.getInputNumber();
			String text = new String(); 
			if (numberItem == EXIT_INPUT) {
				viewPage.setPage(new ProjectPage());
			} else if (numberItem == REWARD_ITEM_1) {
				project.setGatheredBudget(1);
				text = "Thank, You obtain a reward: BIG THANK!";
			} else if (numberItem == REWARD_ITEM_2) {
				project.setGatheredBudget(10);
				text = "Thank, You obtain a reward: Solo supporter!";
			} else if (numberItem == REWARD_ITEM_3) {
				project.setGatheredBudget(40);
				text = "Thank, You obtain a reward: Calm supporter!";
			} else {
				text = "Plese, select right menu item...";
				isExitSelect = true;
			}
			io.println(text);
		} while (isExitSelect);
	}

	private void showMenu(Project project) {
		io.println("1 - 1$ - BIG THANK!");
		io.println("2 - 20$ - Solo supporter!");
		io.println("3 - 40$ - Calm supporter!");
		io.println("0 - to back");
		io.print("Please, select menu item...");
    }

}
