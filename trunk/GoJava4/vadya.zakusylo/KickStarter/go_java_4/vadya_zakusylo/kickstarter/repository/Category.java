package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.Arrays;

public class Category {
	private String nameCategory;
	private Project[] projects = new Project[0];

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public Project[] getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		int length = projects.length;
		projects = Arrays.copyOf(projects, ++length);
		projects[length - 1] = project;
	}
}