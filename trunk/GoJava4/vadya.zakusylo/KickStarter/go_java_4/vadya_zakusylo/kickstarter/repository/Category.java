package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.LinkedHashSet;
import java.util.Set;

public class Category {
	private String nameCategory;
	private Set<Project> projects;

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
		projects = new LinkedHashSet<Project>();
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		projects.add(project);
	}
}