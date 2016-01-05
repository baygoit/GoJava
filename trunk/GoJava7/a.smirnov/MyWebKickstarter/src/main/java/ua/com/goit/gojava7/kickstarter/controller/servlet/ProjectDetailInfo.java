package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

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
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet("/project")
public class ProjectDetailInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private FaqDao faqDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectedProjectId = Integer.parseInt(request.getParameter("id"));

		Project project = projectDao.getProjectById(selectedProjectId);
		project.setCollectedSum(paymentDao.getSumProjectPayments(selectedProjectId));

		List<Faq> questions = faqDao.getProjectFaqs(selectedProjectId);

		request.setAttribute("project", project);
		request.setAttribute("questions", questions);
		request.getRequestDispatcher("WEB-INF/views/project.jsp").forward(request, response);
	}
}
