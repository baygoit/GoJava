package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.InvestmentDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;


public class ProjectServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectId = request.getParameter("projectId");
		int proId = 0;
		try {
			proId = Integer.valueOf(projectId);
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
		
		InvestmentDao investmentDao = getInvestmentDao();
		long investmentSum = investmentDao.getPaymentSum(proId);
		request.setAttribute("investmentSum", investmentSum);
		
		int categoryId = getProjectDao().getCategoryId(proId);
		request.setAttribute("categoryId", categoryId);
		
		Project project = getProjectDao().getProject(proId);
		request.setAttribute("project", project);

		List<Question> questions = getQuestionDao().getQuestions(proId);
		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("question");
		String projectId = request.getParameter("projectId");
		int proId = Integer.valueOf(projectId);
		if(!getQuestionDao().isQuestionValid(proId, question)){
			request.setAttribute("question", question);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		getQuestionDao().writeQuestionInProject(proId, question);
		response.sendRedirect("projectServlet?projectId="+proId);
	}

}
