package go_java_4.vadya_zakusylo.kickstarter.repository;

import java.util.ArrayList;
import java.util.List;

public class Category implements CategoryInterface {
	private String nameCategory;
	private List<ProjectInterface> projects;

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
		projects = new ArrayList<ProjectInterface>();
	}

	public String getName() {
		return nameCategory;
	}

	public void addProject(ProjectInterface oneProject) {
		projects.add(oneProject);
	}

	public void removeProject(ProjectInterface oneProject) {
		int index = projects.indexOf(oneProject);
		if (index >= 0) {
			projects.remove(index);
		}
	}

	public List<ProjectInterface> getProjects() {
		return projects;
	}

}