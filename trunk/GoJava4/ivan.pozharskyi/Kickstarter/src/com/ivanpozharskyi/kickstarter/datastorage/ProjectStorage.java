package com.ivanpozharskyi.kickstarter.datastorage;

public class ProjectStorage {
	private static final int AMOUNT_OF_PROJECTS = 9;
	private Project[] projects = new Project[AMOUNT_OF_PROJECTS];
	private int size = 0;

	public void addProject(Project project) {
		projects[size++] = project;
	}

	public ProjectStorage getProjectsInCategory(Category category) {
		ProjectStorage result = new ProjectStorage();
		for (int i = 0; i < size; i++) {
			if (projects[i].getCaegory().equals(category)) {
				result.addProject(projects[i]);
			}
		}
		return result;
	}

	public Project getProject(int id) {
		return projects[id - 1];
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < size; i++) {
			result.append(projects[i]);
			result.append("\n");
		}
		return result.toString();
	}

}
