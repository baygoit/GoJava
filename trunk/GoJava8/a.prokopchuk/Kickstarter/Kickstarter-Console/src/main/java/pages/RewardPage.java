package pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Project;

public class RewardPage implements Page {
	
	ViewPage viewPage;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		List<Project> projects = viewPage.categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		viewPage.io.println(SOLID_LINE);
		viewPage.io.println("Rewards");
		viewPage.io.println(SOLID_LINE);
		showMenu(project);
		selectReward(project);
		
		viewPage.setPage(new ProjectPage());
	}
	
	private void selectReward(Project project) {
		boolean isExitSelect = false;
		do {
			int numberItem = viewPage.getInputNumber();
			if (numberItem == EXIT_INPUT) {
				viewPage.setPage(new ProjectPage());
			} else if (numberItem == 1) {
				project.setGatheredBudget(1);
				viewPage.io.println("Thank, You obtain a reward: BIG THANK!");
			} else if (numberItem == 2) {
				project.setGatheredBudget(10);
				viewPage.io.println("Thank, You obtain a reward: Solo supporter!");
			} else if (numberItem == 3) {
				project.setGatheredBudget(40);
				viewPage.io.println("Thank, You obtain a reward: Calm supporter!");
			} else {
				viewPage.io.print("Plese, select right menu item...");
				isExitSelect = true;
			}
		} while (isExitSelect);
		viewPage.setPage(new ProjectPage());
	}

	private void showMenu(Project project) {
		viewPage.io.println("1 - 1$ - BIG THANK!");
		viewPage.io.println("2 - 20$ - Solo supporter!");
		viewPage.io.println("3 - 40$ - Calm supporter!");
		viewPage.io.println("0 - to back");
		viewPage.io.print("Please, select menu item...");
    }

}
