package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.models.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public void init() {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		response.sendRedirect("project?id=" + projectId);
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
