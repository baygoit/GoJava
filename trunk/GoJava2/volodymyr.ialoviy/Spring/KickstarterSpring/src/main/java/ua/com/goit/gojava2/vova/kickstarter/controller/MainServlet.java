package ua.com.goit.gojava2.vova.kickstarter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;

public class MainServlet extends HttpServlet {
	
	@Autowired
	private Categories categoriesDAO;
	
	@Autowired
	private Projects projectsDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String action = getAction(req);

		if (action.startsWith("/categories")) {

			List<Category> categories = categoriesDAO.getCategories();

			toJsp(req, resp, categories, "categories");
		} else if (action.startsWith("/projects")) {
			int categoryID = Integer.valueOf(req.getParameter("category"));

			List<Project> projects = projectsDAO.getProgectsForCategory(categoryID);

			toJsp(req, resp, projects, "projects");
		} else if (action.startsWith("/project")) {
			int projectID = Integer.valueOf(req.getParameter("project"));

			Project project = projectsDAO.getProgect(projectID);

			toJsp(req, resp, project, "project");
		}

	}

	private void toJsp(HttpServletRequest req, HttpServletResponse resp,
			Object list, String name) throws ServletException,
			IOException {
		req.setAttribute(name, list);
		req.getRequestDispatcher(name + ".jsp").forward(req, resp);
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		return requestURI.substring(req.getContextPath().length(), requestURI.length());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
	}

}
