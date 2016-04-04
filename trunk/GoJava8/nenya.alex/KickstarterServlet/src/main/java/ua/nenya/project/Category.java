package ua.nenya.project;

import java.util.ArrayList;
import java.util.List;


import ua.nenya.project.Project;

public class Category{
	private int id;
	private String name;
	private List<Project> projects = new ArrayList<>();

	public Category() {
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
