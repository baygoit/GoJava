package ua.com.sas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.Category;
import ua.com.sas.model.Project;

public class ProjectsAction implements Action {

	private ProjectsDAO projectsDAO;

	public ProjectsAction(ProjectsDAO projectsDAO) {
		this.projectsDAO = projectsDAO;
	}

	@Override
	public String getJsp(HttpServletRequest req, HttpServletResponse resp) {
		int categoryId = Integer.valueOf(req.getParameter("category"));
		List<Project> projects = projectsDAO.getProjects(new Category(categoryId));
		req.setAttribute("projects", projects);
		return "projects.jsp";
	}

}
