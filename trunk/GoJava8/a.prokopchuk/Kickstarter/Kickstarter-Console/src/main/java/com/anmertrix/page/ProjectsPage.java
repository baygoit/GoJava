package com.anmertrix.page;

import java.util.List;

import com.anmertrix.IO;
import com.anmertrix.ViewPage;
import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Project;

public class ProjectsPage implements Page {
	
	private ViewPage viewPage;
	private IO io;
	private CategoryDao categoryDao;
	
	@Override
	public void viewPage(ViewPage viewPage) {
		this.viewPage = viewPage;
		this.io = viewPage.getIo();
		this.categoryDao = viewPage.getCategoryDao();
		
		try {
			io.println(SOLID_LINE);
			io.println(categoryDao.getCategory(viewPage.getSelectedMenuItemCategory()).getName());
			io.println(SOLID_LINE);
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
		List<Project> projects = categoryDao.getProjectsByCategoryId(viewPage.getSelectedMenuItemCategory());
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			io.println((i + 1) + " - " + project.getName());
		}
		io.println("0 - to back");
		io.println("");
		io.print("Please, select project...");
	}

}
