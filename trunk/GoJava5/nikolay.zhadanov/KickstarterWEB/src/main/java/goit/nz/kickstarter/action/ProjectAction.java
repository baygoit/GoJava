package goit.nz.kickstarter.action;

import goit.nz.kickstarter.model.ProjectModel;
import goit.nz.kickstarter.storage.DataStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectAction implements Action {
	private ProjectModel model;
	private final String VIEW = "project";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, DataStorage storage) {
		long projectId = Long.parseLong(request.getParameter("id"));
		String actionType = request.getParameter("action");
		if ("view".equals(actionType)) {
			model = new ProjectModel(storage);
			model.update(projectId);
		}
		request.setAttribute("model", model.getProject());
		return VIEW;
	}

}
