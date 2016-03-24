package com.anmertrix.pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Project;

public class QuestionPage implements Page {
	
	@Override
	public void viewPage(ViewPage viewPage) {
		List<Project> projects = viewPage.categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		viewPage.io.println(SOLID_LINE);
		viewPage.io.println("Questions and Answers");
		viewPage.io.println(SOLID_LINE);
		viewPage.io.print("Enter your guestion: ");
		String guestion = viewPage.io.readConsole();
		project.setQuestion(guestion);
		
		viewPage.setPage(new ProjectPage());
		
	}

}
