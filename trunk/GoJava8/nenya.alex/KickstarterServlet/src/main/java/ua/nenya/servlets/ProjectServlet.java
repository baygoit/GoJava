package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.project.Question;

public class ProjectServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
	private Project project;

	@Override
	public void init() {
		super.init();
		categoryDao = initilizer.getCategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> categories = categoryDao.getCategories();
		String projectIndexStr = request.getParameter("projectIndex");
		String categoryIndexStr = request.getParameter("categoryIndex");
		int projectIndex = 0;
		int categoryIndex = 0;
		try {
			projectIndex = Integer.parseInt(projectIndexStr);
			categoryIndex = Integer.parseInt(categoryIndexStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		request.setAttribute("categoryIndex", categoryIndex);
		request.setAttribute("projectIndex", projectIndex);

		Category category = categories.get(categoryIndex);
		List<Project> projects = categoryDao.initProjects(category);
		project = projects.get(projectIndex);
		request.setAttribute("project", project);

		List<Question> questions = categoryDao.initQuestions(project);

		request.setAttribute("questions", questions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/project.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionString = request.getParameter("question");
		Question question = new Question();
		question.setName(questionString);
		categoryDao.writeQuestionInProject(project, question);
		doGet(request, response);
	}

}
