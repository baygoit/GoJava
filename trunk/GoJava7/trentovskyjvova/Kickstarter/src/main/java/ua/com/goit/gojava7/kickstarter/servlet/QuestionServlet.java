package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionDao questionDao;
	
	private DaoProvider daoProvider;
	protected WebApplicationContext applicationContext;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

		daoProvider = applicationContext.getBean(DaoProvider.class);
		//daoProvider.open();
		super.init(config);
	}
	
	@Override
	public void init() throws ServletException {
		questionDao = daoProvider.getQuestionReader();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher("/WEB-INF/jsp/question.jsp").forward(request, response);
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
