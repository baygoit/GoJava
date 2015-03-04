package ua.com.sas.servlet;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.sas.model.*;

public class MainServlet extends HttpServlet {

	private ConnectionDAO connectionDAO = new ConnectionDAO("kickstarter_db", "postgres", "gfhfien17");
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		String action = getAction(req);
		if (action.startsWith("/categories")) {
			
			CategoriesDAO categoriesDAO = new CategoriesDAO(connectionDAO);	
			categoriesDAO.getCategories();
			
			req.setAttribute("categories", null);
			
//			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if (action.equals("/projects")) {
			String categoryName = req.getParameter("category");
			
			ProjectsDAO projectsDAO = new ProjectsDAO(connectionDAO);	
			List<Project> projects = projectsDAO.chooseProjects(new Category(categoryName));
			
			req.setAttribute("projects", projects);
			
//			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("project"));
			
			ProjectsDAO projectsDAO = new ProjectsDAO(connectionDAO);	
			Project project = projectsDAO.readObject(1);
			
			req.setAttribute("project", project);
			
//			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}		
	}
	
	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI(); // TODO поискать более короткий способ сделать это
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}
}
