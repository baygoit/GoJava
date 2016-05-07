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
		Long proId = 0L;
		try {
			proId = Long.valueOf(projectId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", projectId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		request.setAttribute("projectId", proId);
		Project project = projectDao.getProjectByProjectId(proId);

		if (!projectDao.isProjectExist(proId)) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		Category category = project.getCategory();
		request.setAttribute("categoryId", category.getId());

		request.setAttribute("project", project);

		List<Question> questions = questionDao.getQuestions(proId);
		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionStr = request.getParameter("question");
		String projectId = request.getParameter("projectId");
		Long proId = Long.valueOf(projectId);

		Question question = new Question();
		question.setName(questionStr);
		question.setProject(projectDao.getProjectByProjectId(proId));

		Question savedQuestion = questionDao.writeQuestionInProject(question);
		if(savedQuestion != null){
			response.sendRedirect("projectServlet?projectId=" + proId);
		}else{
			request.setAttribute("question", question.getName());
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	}

}
