package goit.nz.kickstarter.action;

import goit.nz.kickstarter.service.ProjectService;

import javax.servlet.http.HttpServletRequest;

public class AddQuestionAction implements Action {
	private String view;
	private ProjectService projectService;

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public String execute(HttpServletRequest request) {
		String question = request.getParameter("question");
		long projectId = Long.parseLong(request.getParameter("id"));
		projectService.addQuestion(projectId, question);
		view = "project?id=" + projectId + "&action=view";
		return view;
	}

}
