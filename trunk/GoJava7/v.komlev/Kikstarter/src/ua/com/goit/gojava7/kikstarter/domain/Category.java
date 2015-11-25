package ua.com.goit.gojava7.kikstarter.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * create class Category which contain list categories
 * 
 */
public class Category {

	private String categoryName;
	private List<Project> projectsList = new ArrayList<>();

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getNameCategory() {
		return categoryName;
	}

	public void setNameCategory(String nameCategory) {
		this.categoryName = nameCategory;
	}

	public List<Project> getAllProjectsInThisCategory() {
		return projectsList;
	}

	public void setProject(Project project) {
		projectsList.add(project);
	}

	public Project getProject(int num) {
		return projectsList.get(num);
	}

}
