package com.gojava2.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorageInVM {
	
	private List<Project> projects;
	
	public ProjectStorageInVM() {
		projects = new ArrayList<Project>();
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public Project getSpecificProject(Category category, int i){
		return getSpecificProjects(category).get(i - 1);
	}
	
	public List<Project> getSpecificProjects(Category category) {
		List<Project> result = new ArrayList<Project>();
		for(Project project: projects) {
			if(project.getCategory().equals(category)) {
				result.add(project);
			}
		}
		return result;
	}
}