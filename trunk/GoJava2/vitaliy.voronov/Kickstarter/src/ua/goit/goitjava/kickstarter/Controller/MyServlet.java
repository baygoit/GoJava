package ua.goit.goitjava.kickstarter.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.goit.goitjava.kickstarter.DB.CategoriesDAO;
import ua.goit.goitjava.kickstarter.DB.ProjectDAO;
import ua.goit.goitjava.kickstarter.model.Category;
import ua.goit.goitjava.kickstarter.model.Project;


public class MyServlet extends HttpServlet {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = getAction(req);
		System.out.println(action);
		if (action.startsWith("/categories")) {
			
			CategoriesDAO categoriesDAO = new CategoriesDAO();	
			List<Category> categories = categoriesDAO.getAllCategories();
			
			req.setAttribute("categories", categories);
			
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if (action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			
			ProjectDAO projectDAO = new ProjectDAO();	
			List<Project> projects = projectDAO.getListProjectByCategoryId(categoryId);
			
			req.setAttribute("projects", projects);
			
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("project"));
			
			ProjectDAO projectDAO = new ProjectDAO();	
			//Project project = projectDAO.getProjectById(projectId,categoryId);
			
			//req.setAttribute("project", project);
			
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
	}


}
