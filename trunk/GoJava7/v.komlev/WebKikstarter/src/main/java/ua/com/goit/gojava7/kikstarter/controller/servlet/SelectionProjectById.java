package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kikstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@WebServlet("/project")
public class SelectionProjectById extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private PaymentDao paymentDao;

	public void init() throws ServletException {

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int projectId = Integer.parseInt(request.getParameter("id"));
		
		Project project = projectDao.getProjectById(projectId);
		project.setCollectedSum(paymentDao.getSumOfProject(project.getId()));
		
		request.setAttribute("project", project);
		request.getRequestDispatcher("WEB-INF/jsp/selected_project.jsp").forward(request, response);
		
	}

}
