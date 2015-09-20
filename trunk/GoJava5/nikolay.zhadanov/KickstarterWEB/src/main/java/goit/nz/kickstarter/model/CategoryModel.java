package goit.nz.kickstarter.model;

import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.domain.Project;

import java.util.List;

public class CategoryModel {
	private Category category;
	private List<Project> projects;

	public Category getCategory() {
		return category;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
