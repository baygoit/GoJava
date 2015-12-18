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
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;

/**
 * Servlet implementation class AskQuestion
 */
@WebServlet("/ask")
public class AskQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int projectId;
	private String userName;
	private String question;

	@Autowired
	private FaqDao faqDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		projectId = Integer.parseInt(request.getParameter("id"));

		request.getRequestDispatcher("WEB-INF/views/ask_question.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errors", false);

		validateUserName(request, response);
		validateQuestion(request, response);

		if ((Boolean) request.getAttribute("errors")) {
			request.getRequestDispatcher("WEB-INF/views/ask_question.jsp").forward(request, response);
		} else {
			saveCreatedFaq();

			response.sendRedirect("/kickstarter/project?id=" + projectId);
		}
	}

	protected void validateUserName(HttpServletRequest request, HttpServletResponse response) {
		userName = request.getParameter("first-name");

		if (userName.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("nameError", true);
		}
	}

	protected void validateQuestion(HttpServletRequest request, HttpServletResponse response) {
		question = request.getParameter("question");

		if (question.isEmpty()) {
			request.setAttribute("errors", true);
			request.setAttribute("questionError", true);
		}
	}

	protected void saveCreatedFaq() {
		Faq faq = new Faq();
		faq.setQuestion(question);
		faq.setProjectID(projectId);
		faqDao.add(faq);
	}
}
