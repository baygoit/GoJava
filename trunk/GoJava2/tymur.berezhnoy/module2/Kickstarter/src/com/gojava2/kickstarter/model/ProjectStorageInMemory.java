package com.gojava2.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorageInMemory {
	
	private int size;
	private List<Project> projects;
	
	public ProjectStorageInMemory() {
		projects = new ArrayList<Project>();
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public Project getProject(Category category, int i){
		List<Project> p = getProjects(category);
		return p.get(i - 1);
	}
	
	public List<Project> getProjects(Category category) {
		List<Project> result = new ArrayList<Project>();
		for(Project project: projects) {
			if(project.getCategory().equals(category)) {
				result.add(project);
			}
			size = result.size();
		}
		return result;
	}
	
	public int getSize() {
		return size;
	}
}