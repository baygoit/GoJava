package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.DataStorage;
import goit.nz.kickstartermvc.dao.Project;

public class ProjectModel {

	private Project currentProject;
	private DataStorage storage;

	public ProjectModel(DataStorage storage) {
		this.storage = storage;
	}

	public void update(String categoryName, int projectIndex) {
		currentProject = storage.getProjects(categoryName)
				.get(projectIndex - 1);
	}

	public Project getProject() {
		return currentProject;
	}

	public void updatePledgedAmount(String categoryName, int projectIndex,
			int amount) {
		storage.addPledgedAmount(categoryName, projectIndex, amount);
	}

}
