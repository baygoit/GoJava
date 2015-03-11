package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;

public class ProjectsAction implements Action {

	private Projects dao;

	public ProjectsAction(Projects projectsDAO) {
		dao = projectsDAO;
	}

	@Override
	public String doIt(HttpServletRequest req, HttpServletResponse resp) {
		int categoryID = Integer.valueOf(req.getParameter("category"));
		List<Project> projects = dao.getProgectsForCategory(categoryID);
		req.setAttribute("projects", projects);
		return "projects.jsp";
	}

}
