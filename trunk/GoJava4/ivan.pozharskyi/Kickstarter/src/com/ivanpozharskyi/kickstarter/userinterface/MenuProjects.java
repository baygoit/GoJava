package com.ivanpozharskyi.kickstarter.userinterface;

import java.sql.SQLException;

import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.Projects;
import com.ivanpozharskyi.kickstarter.entity.ProjectsImpl;

public class MenuProjects implements Menu {
	private Projects projects;
	private Category category;
	private Printer printer;

	public MenuProjects(Projects projects, Printer printer) {
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

	public void show() throws SQLException {
		//printer.println(projects.getProjectsInCategory(category).toString());
		StringBuilder result = new StringBuilder();
		for(Project project: projects.getProjectsInCategory(category)){
			result.append(project+"\n");
			
		}
		printer.println(result.toString());
		printer.println("Choose project: ");

	}

}
