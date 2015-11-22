package ua.com.goit.gojava7.kickstarter.storage_in_memory;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;

public class ProjectsStorage implements ProjectDAO {
	
	private List<Project> projects = new ArrayList<>();
	
	public ProjectsStorage() {
	
		Project project1 = new Project("Project 1", "Brief description 1", 30_000);
		project1.setDeadline(7, 12, 2015);
		project1.setUniqueID(1);
		project1.setCategoryID(1);

		Project project2 = new Project("Project 2", "Brief description 2", 45_000);
		project2.setDeadline(8, 12, 2015);
		project2.setUniqueID(2);
		project2.setCategoryID(1);
		
		Project project3 = new Project("Project 3", "Brief description 3", 50_000);
		project3.setDeadline(11, 12, 2015);
		project3.setUniqueID(3);
		project3.setCategoryID(2);
		
		Project project4 = new Project("Project 4", "Brief description 4", 88_000);
		project4.setDeadline(14, 12, 2015);
		project4.setUniqueID(4);
		project4.setCategoryID(3);
		
		Project project5 = new Project("Project 5", "Brief description 5", 90_000);
		project5.setDeadline(18, 12, 2015);
		project5.setUniqueID(5);
		project5.setCategoryID(3);
		
		add(project1);
		add(project2);
		add(project3);
		add(project4);
		add(project5);

	}

	@Override
	public void add(Project project) {
		projects.add(project);
		
	}

	@Override
	public void remove(Project project) {
		projects.remove(project);
		
	}

	@Override
	public List<Project> getAll() {
		return projects;
	}

	@Override
	public int getSize() {
		return projects.size();
	}
	
	@Override
	public List<Project> getProjectsFromCategory(Category category) {
		List<Project> projectsFromCategory = new ArrayList<>();
		
		for (Project project : projects) {
			if (project.getCategoryID() == category.getUniqueID()) {
				projectsFromCategory.add(project);
			}
		}
		return projectsFromCategory;
	}
}
