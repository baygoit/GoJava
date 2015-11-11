package ua.com.goit.gojava7.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String categoryName;
	private List<Project> projects = new ArrayList<>();

	public Category(String name) {
		this.categoryName = name;
	}

	public List<Project> getAllProjectsInCategory() {
		return projects;
	}

	public String getName() {
		return this.categoryName;
	}

	public void setProject(Project project) {
		projects.add(project);
	}

	public Project getProject(int num) {
		return projects.get(num - 1);
	}
}
