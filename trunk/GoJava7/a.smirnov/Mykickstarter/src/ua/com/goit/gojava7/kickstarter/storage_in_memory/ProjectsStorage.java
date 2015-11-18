package ua.com.goit.gojava7.kickstarter.storage_in_memory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.templates.AbstractStorage;

public class ProjectsStorage extends AbstractStorage<Project> {
	
	public ProjectsStorage(CategoriesStorage categoriesStorage) {
	
		Project project1 = new Project("Project 1", "Brief description 1", 30_000);
		project1.setDeadline(7, 12, 2015);
		project1.setCategoryID(1);

		Project project2 = new Project("Project 2", "Brief description 2", 45_000);
		project2.setDeadline(8, 12, 2015);
		project2.setCategoryID(1);
		
		Project project3 = new Project("Project 3", "Brief description 3", 50_000);
		project3.setDeadline(11, 12, 2015);
		project3.setCategoryID(2);
		
		Project project4 = new Project("Project 4", "Brief description 4", 88_000);
		project4.setDeadline(14, 12, 2015);
		project4.setCategoryID(3);
		
		Project project5 = new Project("Project 5", "Brief description 5", 90_000);
		project5.setDeadline(18, 12, 2015);
		project5.setCategoryID(3);
		
		add(project1);
		add(project2);
		add(project3);
		add(project4);
		add(project5);
		
		setProjectsID();
	}
	
	public List<Project> getProjectsFromCategory(Category category) {
		List<Project> allExistingProjects = getAll();
		List<Project> categoryProjects = new ArrayList<>();
		
		for (Project project : allExistingProjects) {
			if (project.getCategoryID() == category.getUniqueID()) {
				categoryProjects.add(project);
			}
		}
		
		return categoryProjects;
	}
	
	public void setProjectsID() {
		List<Project> projects = getAll();
		for (int index = 0; index < projects.size(); index++) {
			Project project = projects.get(index);
			project.setUniqueID(index + 1);
		}
	}
}
