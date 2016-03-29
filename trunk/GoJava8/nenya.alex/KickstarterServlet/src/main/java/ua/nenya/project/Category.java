package ua.nenya.project;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import ua.nenya.project.GettingNameInterface;
import ua.nenya.project.Project;

@JsonAutoDetect
public class Category implements GettingNameInterface {
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
}
