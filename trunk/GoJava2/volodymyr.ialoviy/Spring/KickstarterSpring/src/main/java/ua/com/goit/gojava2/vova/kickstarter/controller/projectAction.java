package ua.com.goit.gojava2.vova.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;

public class projectAction implements Action {

	private Projects dao;

	public projectAction(Projects projectsDAO) {
		dao = projectsDAO;
	}

	@Override
	public String doIt(HttpServletRequest req, HttpServletResponse resp) {
		int projectID = Integer.valueOf(req.getParameter("project"));
		Project project = dao.getProgect(projectID);
		req.setAttribute("project", project);
		return "project.jsp";
	}

}
