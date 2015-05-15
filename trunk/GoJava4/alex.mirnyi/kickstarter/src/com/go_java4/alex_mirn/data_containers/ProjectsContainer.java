package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Project;

public class ProjectsContainer {
	public List<com.go_java4.alex_mirn.data.Project> categories;

	public ProjectsContainer() {
		categories = new ArrayList<Project>();
	}

	public Project get(int index) {
		return categories.get(index);
	}

	public int size() {
		return categories.size();
	}

	public void add(Project project) {
		categories.add(project);
	}

	public List<Project> getProjects() {
		return categories;
	}
}
