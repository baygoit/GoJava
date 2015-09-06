package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.ProjectDAO;

import javax.servlet.http.HttpServletRequest;

public class PledgeAction implements Action {
	private String view;
	private ProjectDAO projectDAO;

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	@Override
	public String execute(HttpServletRequest request) {
		if ("POST".equals(request.getMethod())) {
			long projectId = Long.parseLong(request.getParameter("id"));
			int pledgedAmount = Integer.parseInt(request
					.getParameter("pledgeAmount"));
			projectDAO.updatePledgedAmount(projectId, pledgedAmount);
			view = "pledge?id=" + projectId + "&done=yes";
		} else {
			view = "pledge";
		}
		return view;
	}

}
