package ua.com.scread.kickstarter.model;

import java.util.List;

import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.Project;
import ua.com.scread.kickstarter.storage.Categories;
import ua.com.scread.kickstarter.storage.InMemoryCategories;
import ua.com.scread.kickstarter.storage.InMemoryProjects;
import ua.com.scread.kickstarter.storage.Projects;

public class Model {
	private Categories categories;
	private Projects projects;
	
	public Model() {
		categories = new InMemoryCategories();
		projects = new InMemoryProjects();
	}
	
	public Model(Categories categories, Projects projects) {
	    this.categories = categories;
	    this.projects = projects;
	}
	
	public Categories getCategories() {
		return categories;
	}
	
	public List<Project> getProjects(Category category) {
		return projects.getProjects(category);
	}
	
}
