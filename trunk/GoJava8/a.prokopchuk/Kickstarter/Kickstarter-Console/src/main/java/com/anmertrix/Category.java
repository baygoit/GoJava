package com.anmertrix;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	private String name;
	private List<Project> projects = new ArrayList<Project>();
	
	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setProject(Project project) {
		projects.add(project);
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public Project getProject(int i) {
		return projects.get(i);
	}
}
