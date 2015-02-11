package ua.home.kickstarter.controller;

import java.util.List;
import java.util.Map;

import ua.home.kickstarter.content.Category;
import ua.home.kickstarter.content.Project;
import ua.home.kickstarter.model.ProjectStorage;

public class ProjectsController {
private ProjectStorage projectStorage;
	
	public ProjectsController() {
		projectStorage = new ProjectStorage();
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

	public int passSpecificCategorySize(Category category) {
		return projectStorage.projectsInSpecificCategorySize(category);
	}
}
 