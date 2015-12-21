package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

@WebServlet("/category")
public class SelectionProjects extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		List<Project> selectedProjects = projectDao.getProjectsFromCategory(categoryId);
		
		request.setAttribute("category", categoryDao.getCategory(categoryId));
		request.setAttribute("projects", selectedProjects);
		request.getRequestDispatcher("WEB-INF/jsp/projects.jsp").forward(request, response);
		
	}
}
