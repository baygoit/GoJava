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
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	FaqDao faqDao;

	@Autowired
	ProjectDao projectDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projectId = Integer.parseInt(request.getParameter("projectId"));
		String question = request.getParameter("question");

		saveCreatedFaq(projectId, question);
		response.sendRedirect("./project?id=" + projectId);
	}

	void saveCreatedFaq(int projectId, String question) {
		Faq faq = new Faq();
		Project project = projectDao.getProjectById(projectId);
		faq.setProject(project);
		faq.setQuestion(question);
		faqDao.add(faq);
	}
}
