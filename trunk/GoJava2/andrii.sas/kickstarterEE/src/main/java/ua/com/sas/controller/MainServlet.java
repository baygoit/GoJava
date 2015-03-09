package ua.com.sas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.sas.dao.CategoriesDAO;
import ua.com.sas.dao.ProjectsDAO;
import ua.com.sas.model.*;

@Controller
public class MainServlet extends HttpServlet {

	@Autowired
	private CategoriesDAO categoriesDAO;
	
	@Autowired
	private ProjectsDAO projectsDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String action = getAction(req);
		if (action.startsWith("/categories")) {
			List<Category> categories = categoriesDAO.getCategories();
			
			req.setAttribute("categories", categories);
			
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
			
		} else if (action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			List<Project> projects = projectsDAO.getProjects(new Category(categoryId));
			
			req.setAttribute("projects", projects);
			
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));
			
			Project project = projectsDAO.get(projectId);
			
			req.setAttribute("project", project);
			
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}		
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}
}
