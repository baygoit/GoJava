package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.domain.Category;
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
		Project project = getProjectDao().getProjectByProjectId(proId);
		
		if(!getProjectDao().isProjectExist(proId)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		getProjectDao().getProjectPayments(project);
		long investmentSum = getProjectDao().getPaymentSum(project);
		request.setAttribute("investmentSum", investmentSum);
		
		
		Category category = project.getCategory(); 
		request.setAttribute("categoryId", category.getId());
		
		request.setAttribute("project", project);

		List<Question> questions = getQuestionDao().getQuestions(proId);
		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionStr = request.getParameter("question");
		String projectId = request.getParameter("projectId");
		int proId = Integer.valueOf(projectId);
		
		Question question = new Question();
		question.setName(questionStr);
		question.setProject(getProjectDao().getProjectByProjectId(proId));
		
		if(questionStr.isEmpty()){
			request.setAttribute("question", questionStr);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		getQuestionDao().writeQuestionInProject(question);
		response.sendRedirect("projectServlet?projectId="+proId);
	}

}
