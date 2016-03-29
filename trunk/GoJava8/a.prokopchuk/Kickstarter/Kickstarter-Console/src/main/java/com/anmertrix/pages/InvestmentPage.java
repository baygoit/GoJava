package com.anmertrix.pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Project;

public class InvestmentPage implements Page {
	
	@Override
	public void viewPage(ViewPage viewPage) {
		
		List<Project> projects = viewPage.categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		viewPage.io.println(SOLID_LINE);
		viewPage.io.println("Invest project");
		viewPage.io.println(SOLID_LINE);
		viewPage.io.print("Enter your amount of money to invest or enter 0 - to back:  ");
		
		int amountInvest = 0;
		do {
			amountInvest = viewPage.getInputNumber();
			if (amountInvest == EXIT_INPUT) {
				viewPage.setPage(new ProjectPage());
			} else if (amountInvest < 0) {
				viewPage.io.print("Plese, enter positive amount of money to invest or enter 0 - to back:  ");
			} else {
				project.setGatheredBudget(amountInvest);
			}
		} while (amountInvest < 0);
		
		viewPage.setPage(new ProjectPage());
	}
}
