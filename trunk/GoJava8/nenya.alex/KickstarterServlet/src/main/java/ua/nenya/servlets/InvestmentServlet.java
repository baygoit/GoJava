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
		String projectName = request.getParameter("projectName");
		request.setAttribute("projectName", projectName);
		if (!getProjectDao().isProjectExist(projectName)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		String categoryName = request.getParameter("categoryName");
		request.setAttribute("categoryName", categoryName);

		Project project = getProjectDao().getProjectByName(projectName);
		request.setAttribute("project", project);

		List<Reward> rewards = getInvestmentDao().getRewards(projectName);
		request.setAttribute("rewards", rewards);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/investment.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String amountString = request.getParameter("amount");
		String projectName = request.getParameter("projectName");
		String categoryName = request.getParameter("categoryName");
		if ("0".equals(amountString)) {
			String investmentString = request.getParameter("investment");
			getInvestmentDao().writeIvestmentInProject(projectName, Integer.parseInt(investmentString));
		} else {
			getInvestmentDao().writeIvestmentInProject(projectName, Integer.parseInt(amountString));
		}

		response.sendRedirect("projectServlet?categoryName=" + categoryName + "&projectName=" + projectName);
	}

}
