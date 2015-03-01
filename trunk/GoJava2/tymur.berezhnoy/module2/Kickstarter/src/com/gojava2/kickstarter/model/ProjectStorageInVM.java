package com.gojava2.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorageInVM {
	
	private List<Project> projects;
	private List<Project> projectsOfCategory;
	
	public ProjectStorageInVM() {
		projects = new ArrayList<Project>();
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public Project getProject(int i){
		return projectsOfCategory.get(i - 1);
	}
	
	public List<Project> getProjectsOfCategory(Category category) {
		projectsOfCategory = new ArrayList<Project>();
		for(Project project: projects) {
			if(project.getCategory().equals(category)) {
				projectsOfCategory.add(project);
			}
		}
		return projectsOfCategory;
	}
	
	public int getSize() {
		return projectsOfCategory.size();
	}
}