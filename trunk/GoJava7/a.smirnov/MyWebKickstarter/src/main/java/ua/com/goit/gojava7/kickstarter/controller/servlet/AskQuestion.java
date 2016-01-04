package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet("/ask")
public class AskQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int projectId;

	@Autowired
	FaqDao faqDao;

	@Autowired
	ProjectDao projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		projectId = Integer.parseInt(request.getParameter("id"));
		request.getRequestDispatcher("WEB-INF/views/question.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errors", false);

		// add field name database
		validateUserName(request);
		String question = validateQuestion(request);

		if ((Boolean) request.getAttribute("errors")) {
			request.getRequestDispatcher("WEB-INF/views/question.jsp").forward(request, response);
		} else {
			saveCreatedFaq(question);
			response.sendRedirect("/kickstarter/project?id=" + projectId);
		}
	}

	String validateUserName(HttpServletRequest request) {
		String userName = request.getParameter("first-name");
		if (userName.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("nameError", true);
		}
		return userName;
	}

	String validateQuestion(HttpServletRequest request) {
		String question = request.getParameter("question");
		if (question.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("questionError", true);
		}
		return question;
	}

	void saveCreatedFaq(String question) {
		Faq faq = new Faq();
		Project project = projectDao.getProjectById(projectId);
		faq.setProject(project);
		faq.setQuestion(question);
		faqDao.add(faq);
	}
}
