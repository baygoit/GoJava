package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.dao.Project;

public class ProjectModel {

	private Project currentProject;

	public void update(Project chosenProject) {
		currentProject = chosenProject;
	}

	public Project getProject() {
		return currentProject;
	}

}
