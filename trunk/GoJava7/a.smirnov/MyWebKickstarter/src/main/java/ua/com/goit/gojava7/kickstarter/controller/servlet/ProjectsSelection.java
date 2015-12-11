package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;

@WebServlet("/category")
public class ProjectsSelection extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProjectDao projectDao;
	private PaymentDao paymentDao;

	public void init() throws ServletException {

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

		projectDao = context.getBean("projectDao", ProjectDao.class);
		paymentDao = context.getBean("paymentDao", PaymentDao.class);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int selectedCategoryId = Integer.parseInt(request.getParameter("id"));

		List<Project> projects = projectDao.getProjectsFromCategory(selectedCategoryId);

		for (Project project : projects) {
			project.setCollectedSum(paymentDao.getSumProjectPayments(project.getUniqueID()));
		}

		request.setAttribute("projects", projects);

		request.getRequestDispatcher("WEB-INF/views/projects_selection.jsp").forward(request, response);
	}
}
