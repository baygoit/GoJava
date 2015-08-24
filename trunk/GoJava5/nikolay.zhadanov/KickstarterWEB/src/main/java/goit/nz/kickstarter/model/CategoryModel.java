package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.memory.Category;
import goit.nz.kickstarter.memory.Project;
import goit.nz.kickstarter.storage.DataStorage;

import java.util.List;

public class CategoryModel {
	private CategoryDAO categoryDAO;
	private ProjectDAO projectDAO;
	private Category category;
	private List<Project> projects;

	public CategoryModel(DataStorage storage) {
		categoryDAO = new CategoryDAO(storage);
		projectDAO = new ProjectDAO(storage);
	}
	
	public void update(long categoryId) {
		category = categoryDAO.getCategory(categoryId);
		projects = projectDAO.getProjects(categoryId);
	}

	public Category getCategory() {
		return category;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

}
