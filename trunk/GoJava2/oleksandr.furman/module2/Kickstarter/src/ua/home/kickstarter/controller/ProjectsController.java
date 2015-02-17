package ua.home.kickstarter.controller;

import java.util.List;
import java.util.Map;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.model.ProjectStorage;

public class ProjectsController {
	private ProjectStorage projectStorage;

	public ProjectsController(ProjectStorage projectStorage) {
		this.projectStorage = projectStorage;
	}

	public Map<Category, List<Project>> getContentToView() {
		return projectStorage.getContent();
	}

	public String getSpecificContentToView(Category category) {
		return projectStorage.getSpecificContent(category);
	}

	public String getSpecificProjectToView(int index, Category category) {
		return projectStorage.getSpecificProjects(index, category);
	}

	public Project getSpecificProject(int index, Category category) {
		return projectStorage.getSpecificProject(index, category);
	}

	public int getSpecificCategorySize(Category category) {
		return projectStorage.projectsInSpecificCategorySize(category);
	}

	public void save() {
		projectStorage.saveJsonToHardDrive();
	}
}
