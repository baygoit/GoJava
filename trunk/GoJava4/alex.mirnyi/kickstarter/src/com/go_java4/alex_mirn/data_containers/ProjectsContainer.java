package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Project;

public class ProjectsContainer {
	public List<com.go_java4.alex_mirn.data.Project> projects;

	public ProjectsContainer() {
		projects = new ArrayList<Project>();
	}

	public Project get(int index) {
		return projects.get(index);
	}

	public int size() {
		return projects.size();
	}

	public void add(Project project) {
		projects.add(project);
	}

	public List<Project> getProjects() {
		return projects;
	}
}
