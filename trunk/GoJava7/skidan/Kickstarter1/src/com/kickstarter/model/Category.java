package com.kickstarter.model;



import java.util.Map;

import com.kickstarter.manager.ProjectManager;

public class Category {

	private String title;
	private int id;
	Map<Integer, Project> projectList;

	public Category(String title, int id)   {
		ProjectManager pm = new ProjectManager();
		this.title = title;
		this.id = id;
		projectList = pm.getAll(this.title);
	}

	public Map<Integer, Project> getProjectList() {
		return projectList;
	}

	public String getTitle() {
		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return  title ;
	}
	
	

}
