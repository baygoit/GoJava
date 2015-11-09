package ua.com.goit.gojava7.kickstarter.storage;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

public class ProjectsStorage extends AbstractStorage<Project> {

	// Printing all projects from selected category
	public List<Project> selectedProjectsFromCartainCategory(Category selectedCategory) {
		List<Project> projectsInCertainCategory = new ArrayList<>();
		List<Project> listOfAllProjects = sourceStorage;

		for (Project project : listOfAllProjects) {
			List<Category> projectCategories = project.getCategories();
			for (Category category : projectCategories) {
				if (selectedCategory.getName().equals(category.getName())) {
					projectsInCertainCategory.add(project);
				}
			}
		}
		return projectsInCertainCategory;
	}
}
