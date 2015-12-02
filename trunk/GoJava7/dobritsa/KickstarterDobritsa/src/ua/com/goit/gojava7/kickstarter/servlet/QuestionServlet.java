package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

	DaoFactory daoFactory;
	ProjectDao projectDao;
	QuestionDao questionDao;

	@Override
	public void init() {
		daoFactory = new DaoFactory(MyDataSource.DB);
		projectDao = daoFactory.getProjectDAO();
		questionDao = daoFactory.getQuestionDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("project?id=44");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String textQuestin = request.getParameter("question");

		if (!request.getParameter("question").isEmpty()) {
			Question question = new Question();
			question.setQuestion(textQuestin);
			question.setProjectId(projectId);
			questionDao.add(question);
		}

		doGet(request, response);
	}

}
