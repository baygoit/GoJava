package com.kickstarter.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectStorage {
	private List<Project> projects;
	private List<Project> result;
	
	public ProjectStorage() {
		projects = new ArrayList<Project>();
	}
	
	public void addProject(Project project) {
		projects.add(project);
	}
	
	public Project getProject(int index) {
		return result.get(index - 1);
	}
	
	public int getSizeProjectsOfCategory() {
		return result.size();
	}
	
   public List<Project> getSpecificProjects(Сategory сategory) {
	   result = new ArrayList<Project>();
	   for(Project p: projects) {
		   if(p.getСategory().equals(сategory)) {
			   result.add(p);
		   }  
	   }
	   return result;
   }
}