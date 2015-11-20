package ua.com.goit.gojava7.kickstarter.model;



import java.util.Map;

import ua.com.goit.gojava7.kickstarter.storage.ProjectStorage;



public class Category {

	private String title;
	private int id;
	Map<Integer, Project> projectList;

	public Category(String title, int id ) {
		this.title = title;
		this.id = id;
		projectList = ProjectStorage.getProjects(this.title);
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

}
