package kickstarter.logic;

import java.io.IOException;

import kickstarter.container.ProjectsContainer;
import kickstarter.model.Category;
import kickstarter.model.Project;
import kickstarter.repos.Repository;

public class OneProjectLogic implements ILogic {
	private Repository repository;

	public OneProjectLogic(Repository repository) {
		this.repository = repository;
	}

	
	public ProjectsContainer getProjects() {
		return repository.projects;
	}

	public Category getCategory(int index1) {
		Category category = repository.categories.get(index1);
		return category;
	}
	
	public int getSize() {
		return repository.projects.size();
	}

	public String getIndex(int index1) {
		String index = repository.projects.get(index1).toString();
		return index;
	}
	
	public Project getProject(int index) {
		Project project = repository.projects.get(index);
		return project;
	}
	
	public String getProjectFullInfo(int index) {
		Project project = repository.projects.get(index);
		return project.getFullInfo();
	}
}
