package com.ivanpozharskyi.kickstarter.userinterface;

import java.util.ArrayList;
import java.util.List;

import com.ivanpozharskyi.kickstarter.engine.Printer;
import com.ivanpozharskyi.kickstarter.entity.Project;
import com.ivanpozharskyi.kickstarter.entity.ProjectsImpl;

public class MenuProject implements Menu {
	private ProjectsImpl projectStorage;
	private Project project;
	private Printer printer;
	private List<Project> projects = new ArrayList<Project>();

	public MenuProject(List<Project> projects, Printer printer) {
		this.projects = projects;
		this.printer = printer;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void show() {
		printer.println((project.getDetailDescription()));
	}

	@Override
	public void setChoise(Object choise) {
		project = (Project) choise;

	}
}
