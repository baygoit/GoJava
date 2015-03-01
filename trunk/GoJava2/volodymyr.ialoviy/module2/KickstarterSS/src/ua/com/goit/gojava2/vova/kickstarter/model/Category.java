package ua.com.goit.gojava2.vova.kickstarter.model;


public class Category{
	
	private int categoryID;
	private String categoryName;
	private int[] projects;
	
	public Category(int categoryID, String categoryName, int[] projects) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.projects = projects;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int[] getProjects() {
		return projects;
	}

	public void setProjectsIn(int[] projectsIn) {
		this.projects = projectsIn;
	}
}
