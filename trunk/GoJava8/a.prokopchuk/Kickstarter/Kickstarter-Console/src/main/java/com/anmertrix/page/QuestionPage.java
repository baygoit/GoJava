package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

public class QuestionPage implements Page {
	
	@Override
	public void viewPage(ViewPage viewPage) {
		CategoryDao categoryDao = viewPage.getCategoryDao();
		IO io = viewPage.getIo();
		
		List<Project> projects = categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		Project project = projects.get(viewPage.getSelectedMenuItemProject() - 1);
		io.println(SOLID_LINE);
		io.println("Questions and Answers");
		io.println(SOLID_LINE);
		io.print("Enter your guestion: ");
		String guestion = io.readConsole();
		project.setQuestion(guestion);
		
		viewPage.setPage(new ProjectPage());
		
	}

}
