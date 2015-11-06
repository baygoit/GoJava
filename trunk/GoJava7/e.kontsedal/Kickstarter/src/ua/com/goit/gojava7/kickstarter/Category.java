package ua.com.goit.gojava7.kickstarter;

import java.util.Collections;
import java.util.List;

public class Category {
	private int categoryId = 0;
	private String categoryName;
	private List<Project> projectsInCategory;

	public Category(String name) {
		this.categoryName = name;
		this.projectsInCategory = ProjectStorage
				.getAllProjectsInCategory(categoryId++);
	}

	public String getName() {
		return this.categoryName;
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public List<Project> getAllProjectsInCategory() {
		return Collections.unmodifiableList(projectsInCategory);
	}

}
