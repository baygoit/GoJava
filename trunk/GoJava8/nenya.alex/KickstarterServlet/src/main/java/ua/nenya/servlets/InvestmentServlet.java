package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.domain.Project;
import ua.nenya.domain.Reward;

public class InvestmentServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectId = request.getParameter("projectId");
		int proId = 0;
		try {
			proId = Integer.parseInt(projectId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", projectId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		request.setAttribute("projectId", proId);
		
		if(!getProjectDao().isProjectExist(proId)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Project project = getProjectDao().getProject(proId);
		request.setAttribute("project", project);

		List<Reward> rewards = getRewardDao().getRewards(proId);
		request.setAttribute("rewards", rewards);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/investment.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String amountString = request.getParameter("amount");
		String projectId = request.getParameter("projectId");
		int proId = 0;
		try {
			proId = Integer.parseInt(projectId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", projectId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		if ("0".equals(amountString)) {
			String investmentString = request.getParameter("investment");
			int investment = 0;
			try{
			investment = Integer.parseInt(investmentString);
			}catch(NumberFormatException e){
				request.setAttribute("investment", -1);
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			getInvestmentDao().writeIvestmentInProject(proId, investment);
		} else {
			getInvestmentDao().writeIvestmentInProject(proId, Integer.parseInt(amountString));
		}

		response.sendRedirect("projectServlet?projectId=" + proId);
	}

}
