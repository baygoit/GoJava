package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.domain.Project;

public class ProjectModel {
	private ProjectDAO projectDAO;
	private Project project;

	public ProjectModel(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public void update(long projectId) {
		project = projectDAO.getProject(projectId);
	}

	public Project getProject() {
		return project;
	}

}
