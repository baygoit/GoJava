package com.anmertrix.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
 
@JsonAutoDetect
public class Category {
	
	public Category() {
		
	}

	private String name;
	
	private List<Project> projects = new ArrayList<Project>();

	public Category(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
