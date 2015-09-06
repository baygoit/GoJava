package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.CategoryDAO;
import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.model.CategoryModel;

import javax.servlet.http.HttpServletRequest;

public class CategoryAction implements Action {
	private CategoryModel model;
	private CategoryDAO categoryDAO;
	private ProjectDAO projectDAO;
	private final String VIEW = "category";

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public String execute(HttpServletRequest request) {
		long categoryId = Long.parseLong(request.getParameter("id"));
		model = new CategoryModel(categoryDAO, projectDAO);
		model.update(categoryId);
		request.setAttribute("model", model);
		return VIEW;
	}

}
