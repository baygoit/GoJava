package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Project;
import ua.nenya.domain.Question;


public class ProjectServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

	@Override
	public void init() {
		super.init();
		categoryDao = getInitilizer().getCategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String projectName = request.getParameter("projectName");
		String categoryName = request.getParameter("categoryName");
		
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("projectName", projectName);
		
		Project project = categoryDao.getProjectByName(projectName);
		request.setAttribute("project", project);

		List<Question> questions = categoryDao.getQuestions(projectName);

		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionString = request.getParameter("question");
		String projectName = request.getParameter("projectName");
		String categoryName = request.getParameter("categoryName");
		
		categoryDao.writeQuestionInProject(projectName, questionString);
	
		response.sendRedirect("projectServlet?categoryName="+categoryName+"&projectName="+projectName);
	}

}
