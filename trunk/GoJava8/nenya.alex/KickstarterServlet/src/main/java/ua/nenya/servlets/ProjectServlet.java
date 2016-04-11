package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;


public class ProjectServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String projectName = request.getParameter("projectName");	
		
		if(!isProjectExists(projectName)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		String categoryName = request.getParameter("categoryName");
		
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("projectName", projectName);
		
		Project project = getProjectDao().getProjectByName(projectName);
		request.setAttribute("project", project);

		List<Question> questions = getQuestionDao().getQuestions(projectName);

		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	private boolean isProjectExists(String projectName) {
		ProjectDao projectDao = getProjectDao();
		Project project = projectDao.getProjectByName(projectName);
		return project.getName()!= null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionString = request.getParameter("question");
		if(!isQuestionValid(questionString)){
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String projectName = request.getParameter("projectName");
		String categoryName = request.getParameter("categoryName");
		
		getQuestionDao().writeQuestionInProject(projectName, questionString);
	
		response.sendRedirect("projectServlet?categoryName="+categoryName+"&projectName="+projectName);
	}

	private boolean isQuestionValid(String questionString) {
		return questionString != null && !questionString.isEmpty() && !questionString.equals("null");
	}

}
