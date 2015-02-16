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
 
	public Map<Category, List<Project>> passContentToView() {
		return projectStorage.getContent();
	}

	public String passSpecificContentToView(Category category) {
		return projectStorage.getSpecificContent(category);
	}

	public String passSpecificProjectToView(int index, Category category) {
		return projectStorage.getSpecificProjects(index, category);
	}

	public Project passSpecificProject(int index, Category category) {
		return projectStorage.getSpecificProject(index, category);
	}

	public int passSpecificCategorySize(Category category) {
		return projectStorage.projectsInSpecificCategorySize(category);
	}

	public void save() {
		projectStorage.saveJsonToHardDrive();
	}
}
