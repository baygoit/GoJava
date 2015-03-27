package ua.com.sas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;

public class ProjectsAction implements Action {

	private CategoriesDAO categoriesDAO;

	public ProjectsAction(CategoriesDAO categoriesDAO) {
		this.categoriesDAO = categoriesDAO;
	}

	@Override
	public String getJsp(HttpServletRequest req, HttpServletResponse resp) {
		int categoryId = Integer.valueOf(req.getParameter("category"));
		Category category = categoriesDAO.get(categoryId);
		List<Project> projects = category.getProjects();
		req.setAttribute("projects", projects);
		return "projects.jsp";
	}

}
