package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.model.Project;
import java.util.Set;
import java.util.TreeSet;

public class Category implements Comparable<Category> {
    private Set<Project> projects;
	private String name;

	public Category(String name) {
		this.name = name;
		projects = new TreeSet<>();
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public Set<Project> getAllProjectsFromCategory() {
		return projects;
	}
	
	public void addProjectToCategory(Project project) {
		projects.add(project);
	}
	
	public void deleteProjectToCategory(Project project) {
		projects.remove(project);
	}
	
	@Override
	public int compareTo(Category that) {
		return this.getName().compareTo(that.getName());
	}
}
