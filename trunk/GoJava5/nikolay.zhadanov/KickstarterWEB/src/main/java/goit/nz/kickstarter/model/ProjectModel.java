package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.memory.Project;
import goit.nz.kickstarter.storage.DataStorage;

public class ProjectModel {
	private ProjectDAO projectDAO;
	private Project project;

	public ProjectModel(DataStorage storage) {
		projectDAO = new ProjectDAO(storage);
	}

	public void update(long projectId) {
		project = projectDAO.getProject(projectId);
	}

	public Project getProject() {
		return project;
	}

}
