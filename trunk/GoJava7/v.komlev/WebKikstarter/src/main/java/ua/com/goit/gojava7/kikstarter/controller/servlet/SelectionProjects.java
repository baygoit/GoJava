
package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@WebServlet("/category")
public class SelectionProjects extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SelectionProjects.class);

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("start method doGet()");

		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		log.info("category_id=" + categoryId);

		List<Project> selectedProjects = projectDao.getProjectsFromCategory(categoryId);
		log.info("Projects: " + selectedProjects);

		for (Project project : selectedProjects) {
			project.setCollectedSum(paymentDao.getSumOfProject(project.getId()));
		}

		request.setAttribute("category", categoryDao.getCategory(categoryId));
		request.setAttribute("projects", selectedProjects);
		request.getRequestDispatcher("WEB-INF/jsp/projects.jsp").forward(request, response);

	}
}
