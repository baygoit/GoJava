package com.anmertrix.pages;

import java.util.List;

import com.anmertrix.ViewPage;
import com.anmertrix.domain.Project;

public class ProjectsPage implements Page {
	
	ViewPage viewPage;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		
		try {
			viewPage.io.println(SOLID_LINE);
			viewPage.io.println(viewPage.categoryDao.getCategory(viewPage.getSelectedMenuItemCategory()).getName());
			viewPage.io.println(SOLID_LINE);
		} catch (Exception e) {
			System.err.println("There is no such category!");
			e.printStackTrace();
			viewPage.setPage(new CategoriesPage());
			return;
		}
		showProjects();
		int selectedMenuItemProject = viewPage.getInputNumber();
		if (selectedMenuItemProject == EXIT_INPUT) {
			viewPage.setPage(new CategoriesPage());
		} else {
			viewPage.setSelectedMenuItemProject(selectedMenuItemProject);
			viewPage.setPage(new ProjectPage());
		}
	}
	
	public void showProjects() {
		List<Project> projects = viewPage.categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			viewPage.io.println((i + 1) + " - " + project.getName());
		}
		viewPage.io.println("0 - to back");
		viewPage.io.println("");
		viewPage.io.print("Please, select project...");
	}

}
