package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {
	private static final String PATH_QUESTION_JSP = "/WEB-INF/jsp/question.jsp";
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(QuestionServlet.class);
	
	@Autowired
	private QuestionDao questionDao;
	@Autowired
	protected RequestValidation requestValidation;
	
	@Override
	public void init() throws ServletException {
		log.info("Starting Spring autowiring...");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		log.info("Ended Spring autowiring...");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doGet");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: {}", projectId);
		
		request.setAttribute("projectId", projectId);
		request.getRequestDispatcher(PATH_QUESTION_JSP).forward(request, response);
		log.info("Ended doGet");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("doPost");
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		log.debug("projectId: {}", projectId);
		
		request.setAttribute("errors", false);
		List<String> emptyCheckParameters = new ArrayList<>(Arrays.asList("questionText"));
		if (requestValidation.isEmpty(request, emptyCheckParameters)) {
			doGet(request, response);
		} else {

			String questionText = request.getParameter("questionText");
			log.debug("questionText: {}", questionText);
			
			Question question = new Question();
			question.setProjectId(projectId);
			question.setQuestionText(questionText);
			questionDao.addQuestion(question);
			log.info("new Question {}", question);
			
			response.sendRedirect("project?projectId=" + projectId);
		}
		log.info("Ended doPost");
	}
	
}
