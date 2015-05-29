package com.ivanpozharskyi.kickstarter.userinterface;

import com.ivanpozharskyi.kickstarter.datastorage.Category;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.engine.Printer;

public class MenuProjects implements Menu {
	private ProjectStorage projects;
	private Category category;
	private Printer printer;

	public MenuProjects(ProjectStorage projects, Printer printer) {
		this.projects = projects;
		this.printer = printer;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public void setChoise(Object choice) {
		category = (Category) choice;

	}

	public void show() {
		printer.println(projects.getProjectsInCategory(category).toString());
		printer.println("Choose project: ");

	}

}
