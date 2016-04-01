package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

public class InvestmentPage implements Page {
	
	@Override
	public void viewPage(ViewPage viewPage) {
		CategoryDao categoryDao = viewPage.getCategoryDao();
		IO io = viewPage.getIo();
		
		List<Project> projects = categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		io.println(SOLID_LINE);
		io.println("Invest project");
		io.println(SOLID_LINE);
		io.print("Enter your amount of money to invest or enter 0 - to back:  ");
		
		int amountInvest = 0;
		do {
			amountInvest = viewPage.getInputNumber();
			if (amountInvest == EXIT_INPUT) {
				viewPage.setPage(new ProjectPage());
			} else if (amountInvest < 0) {
				io.print("Plese, enter positive amount of money to invest or enter 0 - to back:  ");
			} else {
				project.setGatheredBudget(amountInvest);
			}
		} while (amountInvest < 0);
		
		viewPage.setPage(new ProjectPage());
	}
}
