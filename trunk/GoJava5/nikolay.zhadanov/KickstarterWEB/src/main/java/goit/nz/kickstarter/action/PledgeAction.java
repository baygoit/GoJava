package goit.nz.kickstarter.action;

import goit.nz.kickstarter.dao.ProjectDAO;
import goit.nz.kickstarter.storage.DataStorage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PledgeAction implements Action {
	private final String VIEW = "pledge";
	private ProjectDAO projectDAO;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response, DataStorage storage) {
		if ("POST".equals(request.getMethod())) {
			long projectId = Long.parseLong(request.getParameter("id"));
			int pledgedAmount = Integer.parseInt(request
					.getParameter("pledgeAmount"));
			projectDAO = new ProjectDAO(storage);
			projectDAO.updatePledgedAmount(projectId, pledgedAmount);
		}
		return VIEW;
	}

}
