package com.ivanpozharskyi.kickstarter.userinterface;

import com.ivanpozharskyi.kickstarter.datastorage.Project;
import com.ivanpozharskyi.kickstarter.datastorage.ProjectStorage;
import com.ivanpozharskyi.kickstarter.engine.Printer;

public class MenuProject implements Menu {
	private ProjectStorage projectStorage;
	private Project project;
	private Printer printer;

	public MenuProject(ProjectStorage projectStorage, Printer printer) {
		this.projectStorage = projectStorage;
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
