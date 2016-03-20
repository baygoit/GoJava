package ua.kutsenko.KickstarterGoIt.domain;

import java.util.ArrayList;
import java.util.List;

import ua.kutsenko.KickstarterGoIt.Project;

public class Category {
	private String name;
	private List<Project> projectList = new ArrayList<Project>();

	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public void setName(String name){
		this.name = name;
	}

	public List<Project> getProjectList() {
		return projectList;
	}
	
	public void addProject(Project project){
	projectList.add(project);	
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
