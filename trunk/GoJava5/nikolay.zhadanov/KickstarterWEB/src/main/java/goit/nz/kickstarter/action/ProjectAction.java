package goit.nz.kickstarter.action;

import goit.nz.kickstarter.domain.Project;
import goit.nz.kickstarter.model.ProjectModel;
import goit.nz.kickstarter.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

public class ProjectAction implements Action {
	private ProjectModel model;
	private ProjectService projectService;
	private final String VIEW = "project";

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		long projectId = Long.parseLong(request.getParameter("id"));
		String actionType = request.getParameter("action");
		if ("view".equals(actionType)) {
			model = new ProjectModel();
			Project project = projectService.getProject(projectId);
			model.setProject(project);
			model.setEvents(project.getEvents());
			model.setFaqs(project.getFaq());
			model.setRewardOptions(project.getRewardOptions());
			model.setCategory(project.getCategory());
		}
		request.setAttribute("model", model);
		return VIEW;
	}

}
