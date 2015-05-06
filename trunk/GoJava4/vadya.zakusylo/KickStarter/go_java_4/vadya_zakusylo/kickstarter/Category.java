package go_java_4.vadya_zakusylo.kickstarter;

import java.util.Arrays;

public class Category {
	private String nameCategory;

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	private Project[] projects = new Project[0];

	public Project[] getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		int length = projects.length;
		projects = Arrays.copyOf(projects, ++length);
		projects[length - 1] = project;
	}
}