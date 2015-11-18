package ua.com.goit.gojava7.kickstarter.storage_in_files;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.templates.AbstractStorage;

public class ProjectsStorage extends AbstractStorage<Project> {
	
	public ProjectsStorage(CategoriesStorage categoriesStorage) {
	
		Project project1 = new Project("Project 1", "Short description 1", 30_000);
		project1.setDeadline(07, 12, 2015);
		project1.setCategoryID(1);
		
		Project project2 = new Project("Project 2", "Short description 2", 250_000);
		project2.setDeadline(29, 12, 2015);
		project2.setCategoryID(1);
	
		Project project3 = new Project("Project 3", "Short description 3", 10_000);
		project1.setDeadline(17, 12, 2015);
		project1.setCategoryID(2);
		
		Project project4 = new Project("Project 4", "Short description 2", 27_000);
		project2.setDeadline(11, 12, 2015);
		project2.setCategoryID(3);
		
		add(project1);
		add(project2);
		add(project3);
		add(project4);
	}
	
	public List<Project> getAllProjectsFromCategory(Category category) {
		List<Project> projects = getAll();
		List<Project> projectsFromSelectedCategory = new ArrayList<>();

		for (Project project : projects) {
			if (project.getCategoryID() == category.getUniqueID()) {
				projectsFromSelectedCategory.add(project);
			}
		}
		return projectsFromSelectedCategory;

	}
}
