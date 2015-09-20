package goit.nz.kickstarter.action;

import goit.nz.kickstarter.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

public class PledgeAction implements Action {
	private String view;
	private ProjectService projectService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		if ("POST".equals(request.getMethod())) {
			long projectId = Long.parseLong(request.getParameter("id"));
			int pledgedAmount = Integer.parseInt(request
					.getParameter("pledgeAmount"));
			projectService.pledgeAmount(projectId, pledgedAmount);
			view = "pledge?id=" + projectId + "&done=yes";
		} else {
			view = "pledge";
		}
		return view;
	}

}
