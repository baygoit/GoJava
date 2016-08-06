package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;

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
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@WebServlet("/project")
public class SelectionProjectById extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SelectionProjectById.class);

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
		int projectId = Integer.parseInt(request.getParameter("project_id"));
		int categoryId = Integer.parseInt(request.getParameter("category_id"));
		log.info("categoryId=" + categoryId);

		Project project = projectDao.getProjectById(projectId);
		project.setCollectedSum(paymentDao.getSumOfProject(project.getId()));
		Category category = categoryDao.getCategory(categoryId);
		log.info("category id from obejct=" + category.getId());

		request.setAttribute("project", project);
		request.setAttribute("category", category);
		request.getRequestDispatcher("WEB-INF/jsp/selected_project.jsp").forward(request, response);

	}

}
