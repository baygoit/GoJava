package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDao questionDao;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		DaoProvider daoProvider = (DaoProvider) context.getAttribute(ContextListener.STORAGE_FACTORY);
		
		questionDao = daoProvider.getQuestionReader();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Question</title></head><body>");
		stringBuilder.append("<form action=\"question?projectId=").append(projectId).append("\" method=\"post\">");

		stringBuilder.append("<input type=\"text\" name=\"questionText\" placeholder=\"question text\">").append("</br>");
		stringBuilder.append("<input type=\"submit\" value=\"Ask\">");
		stringBuilder.append("</form>");
		stringBuilder.append("</body></html>");

		response.getWriter().append(stringBuilder.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		String questionText = request.getParameter("questionText");
		
		Question question = new Question();
		question.setProjectId(projectId);
		question.setQuestionText(questionText);
		questionDao.addQuestion(question);
		
		response.sendRedirect("project?projectId=" + projectId);
	}

}
