package ua.com.goit.gojava7.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String categoryName;
	private List<Project> projects;

	public Category() {
		// default constructor
	}

	public Category(String name) {
		this.categoryName = name;
		this.projects = new ArrayList<>();
	}

	public void addProject(Project project) {
		projects.add(project);
	}
	
	public List<Project> getAllProjectsInCategory() {
		return projects;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public Project takeProject(int num) {
		return projects.get(num - 1);
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setAllProjectsInCategory(List<Project> projects) {
		this.projects = projects;
	}

}
