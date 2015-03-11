package ua.com.sas.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.Project;

public class ProjectAction implements Action {

	private ProjectsDAO projectsDAO;

	public ProjectAction(ProjectsDAO projectsDAO) {
		this.projectsDAO = projectsDAO;
	}

	@Override
	public String getJsp(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.valueOf(req.getParameter("id"));
		Project project = projectsDAO.get(id);
		req.setAttribute("project", project);
		return "project.jsp";
	}

}
