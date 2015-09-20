package org.dens.kikstarter.data;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String name;
	private String description;
	private List<Project> projects = new ArrayList<>();

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + "]";
	}

	public void addProject(Project project) {
		int length = projects.size();
		for(int index = 0; index < length; index++){
			if(projects.get(index)==null){
				projects.set(index, project);
				return;
			}
		}		
	}

	public List<Project> getProjets() {
		return projects;
	}
	
	

}
