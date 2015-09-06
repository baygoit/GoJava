package goit.nz.kickstarter.model;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.domain.Category;
import goit.nz.kickstarter.domain.Project;

import java.util.List;

public class CategoryModel {
	private CategoryDAO categoryDAO;
	private ProjectDAO projectDAO;
	private Category category;
	private List<Project> projects;

	public CategoryModel(CategoryDAO categoryDAO, ProjectDAO projectDAO) {
		this.categoryDAO = categoryDAO;
		this.projectDAO = projectDAO;
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
