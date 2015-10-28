package com.gojava2.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorageInMemory implements ProjectStorage {
	
	private int size;
	private List<Project> projects; // TODO Change in Map (optional), but i'm not sure;
	
	public ProjectStorageInMemory() {
		projects = new ArrayList<Project>();
	}
	
	@Override
	public void addProject(Project project) {
		projects.add(project);
	}
	
	@Override
	public Project getProject(Category category, int i){
		List<Project> p = getProjects(category);
		return p.get(i - 1);
	}
	
	@Override
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
	
	@Override
	public int getSize() {
		return size;
	}
}