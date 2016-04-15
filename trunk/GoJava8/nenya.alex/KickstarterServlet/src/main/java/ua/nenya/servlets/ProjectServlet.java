package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ua.nenya.domain.Project;
import ua.nenya.domain.Question;


public class ProjectServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String projectName = request.getParameter("projectName");
		request.setAttribute("projectName", projectName);
		
		if(!getProjectDao().isProjectExist(projectName)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		String categoryName = request.getParameter("categoryName");
		request.setAttribute("categoryName", categoryName);
		Project project = getProjectDao().getProjectByName(projectName);
		request.setAttribute("project", project);

		List<Question> questions = getQuestionDao().getQuestions(projectName);
		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("question");
		String projectName = request.getParameter("projectName");
		String categoryName = request.getParameter("categoryName");
		if(!getQuestionDao().isQuestionValid(projectName, question)){
			request.setAttribute("question", question);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		getQuestionDao().writeQuestionInProject(projectName, question);
	
		response.sendRedirect("projectServlet?categoryName="+categoryName+"&projectName="+projectName);
	}

}
