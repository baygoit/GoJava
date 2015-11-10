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
		
	public void addProjectToCategory(Project project) {
		projects.add(project);
	}
	
	public void deleteProjectToCategory(Project project) {
		projects.remove(project);
	}
	
	public Set<Project> getAllProjectsFromCategory() {
		return projects;
	}
	
	@Override
	public int compareTo(Category that) {
		return this.getName().compareTo(that.getName());
	}
	
	@Override
	public boolean equals(Object other) {
		if(!super.equals(other)) return false;
        if (this == other) return true;
        if (other == null) return false;
        if(this.getClass() != other.getClass()) return false;
        Category otherObj = (Category) other;
        return this.name == otherObj.getName();
	}

}
