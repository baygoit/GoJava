package com.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class InMemoryProjects implements Projects {
	private List<Project> projects;
	private List<Project> result;

	public InMemoryProjects() {
		projects = new ArrayList<Project>();
	}

	@Override
	public void add(Project project) {
		projects.add(project);
	}

	@Override
	public Project get(int index) {
		return result.get(index - 1);
	}

	@Override
	public int getSize() {
		return result.size();
	}

	@Override
	public List<Project> getProjects(Сategory сategory) {
		result = new ArrayList<Project>();
		for (Project p : projects) {
			if (p.getСategory().equals(сategory)) {
				result.add(p);
			}
		}
		return result;
	}
}