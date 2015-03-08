package ua.com.sas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.model.*;

public class MainServlet extends HttpServlet {

	private ConnectionDAO connectionDAO = new ConnectionDAO("kickstarter_db", "postgres", "gfhfien17");
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String action = getAction(req);
		if (action.startsWith("/categories")) {
			CategoriesDAO categoriesDAO = new CategoriesDAO(connectionDAO);	
			List<Category> categories = categoriesDAO.getCategories();
			
			req.setAttribute("categories", categories);
			
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
			
		} else if (action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			ProjectsDAO projectsDAO = new ProjectsDAO(connectionDAO);	
			List<Project> projects = projectsDAO.getProjects(new Category(categoryId));
			
			req.setAttribute("projects", projects);
			
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));
			
			ProjectsDAO projectsDAO = new ProjectsDAO(connectionDAO);	
			Project project = projectsDAO.get(projectId);
			
			req.setAttribute("project", project);
			
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}		
	}
	
	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI(); // TODO поискать более короткий способ сделать это
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}
}
