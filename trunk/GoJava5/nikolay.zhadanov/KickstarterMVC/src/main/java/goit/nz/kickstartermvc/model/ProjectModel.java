package goit.nz.kickstartermvc.model;

import goit.nz.kickstartermvc.dao.Project;
import goit.nz.kickstartermvc.dao.RewardOption;
import goit.nz.kickstartermvc.storage.DataStorage;

import java.util.List;

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

	public void addQuestion(String categoryName, int projectIndex,
			String question) {
		storage.addQuestion(categoryName, projectIndex, question);
	}
	
	public List<RewardOption> getRewardOptions() {
		return currentProject.getRewardOptions();
	}

}
