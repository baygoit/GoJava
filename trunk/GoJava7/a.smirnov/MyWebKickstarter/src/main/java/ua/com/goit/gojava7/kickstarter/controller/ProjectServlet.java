package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;
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

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Faq;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Reward;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.FaqDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(ProjectServlet.class);

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private FaqDao faqDao;

	@Autowired
	private RewardDao rewardDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");

		int selectedProjectId = Integer.parseInt(request.getParameter("id"));
		log.info("Selected project id : " + selectedProjectId);

		Project project = projectDao.getProjectById(selectedProjectId);
		project.setCollectedSum(paymentDao.getSumProjectPayments(selectedProjectId));
		log.info("Selected project: " + project);

		List<Faq> questions = faqDao.getProjectFaqs(selectedProjectId);
		log.info("All questions: " + questions);

		List<Category> categories = categoryDao.getAll();
		log.info("All categories : " + categories);

		List<Reward> rewards = rewardDao.getProjectsRewards(selectedProjectId);
		log.info("All rewards: " + rewards);

		request.setAttribute("project", project);
		request.setAttribute("questions", questions);
		request.setAttribute("rewards", rewards);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/pages/project.jsp").forward(request, response);
	}
}
