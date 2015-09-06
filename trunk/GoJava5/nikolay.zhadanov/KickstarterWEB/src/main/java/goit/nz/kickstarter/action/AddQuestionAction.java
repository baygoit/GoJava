package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.ProjectDAO;
import javax.servlet.http.HttpServletRequest;

public class AddQuestionAction implements Action {
	private String view;
	private ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public String execute(HttpServletRequest request) {
		String question = request.getParameter("question");
		long projectId = Long.parseLong(request.getParameter("id"));
		projectDAO.addQuestion(projectId, question);
		view = "project?id=" + projectId + "&action=view";
		return view;
	}

}
