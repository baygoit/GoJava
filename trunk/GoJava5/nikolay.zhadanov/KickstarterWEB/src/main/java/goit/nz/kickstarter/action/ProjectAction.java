package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.model.ProjectModel;

import javax.servlet.http.HttpServletRequest;

public class ProjectAction implements Action {
	private ProjectModel model;
	private ProjectDAO projectDAO;
	private final String VIEW = "project";

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public String execute(HttpServletRequest request) {
		long projectId = Long.parseLong(request.getParameter("id"));
		String actionType = request.getParameter("action");
		if ("view".equals(actionType)) {
			model = new ProjectModel(projectDAO);
			model.update(projectId);
		}
		request.setAttribute("model", model.getProject());
		return VIEW;
	}

}
