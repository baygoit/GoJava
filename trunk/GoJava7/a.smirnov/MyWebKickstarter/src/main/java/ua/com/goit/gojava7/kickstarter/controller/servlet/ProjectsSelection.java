package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@ComponentScan
@WebServlet("/category")
public class ProjectsSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private PaymentDao paymentDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int selectedCategoryId = Integer.parseInt(request.getParameter("id"));

		List<Project> projects = projectDao.getProjectsFromCategory(selectedCategoryId);

		// for (Project project : projects) {
		// project.setCollectedSum(paymentDao.getSumProjectPayments(project.getId()));
		// }

		request.setAttribute("projects", projects);
		request.getRequestDispatcher("WEB-INF/views/projects_selection.jsp").forward(request, response);
	}
}
