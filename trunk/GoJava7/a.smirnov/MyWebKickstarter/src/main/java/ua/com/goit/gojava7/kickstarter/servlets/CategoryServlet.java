package ua.com.goit.gojava7.kickstarter.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

//@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoryServlet.class);

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");

		int selectedCategoryId = Integer.parseInt(request.getParameter("id"));
		log.info("Selected category id: " + selectedCategoryId);

		List<Project> projects = projectDao.getProjectsFromCategory(selectedCategoryId);
		log.info("All projects: " + projects);

		for (Project project : projects) {
			project.setCollectedSum(paymentDao.getSumProjectPayments(project.getId()));
		}
		log.info("All projects after added pledges: " + projects);

		List<Category> categories = categoryDao.getAll();
		log.info("All categories: " + projects);

		request.setAttribute("projects", projects);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/pages/category.jsp").forward(request, response);
	}
}
