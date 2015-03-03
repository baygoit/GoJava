package com.goit.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goit.kickstarter.model.Category;
import com.goit.kickstarter.model.Project;
import com.goit.kickstarter.dao.CategoryDAO;
import com.goit.kickstarter.dao.ProjectDAO;

public class MainServlet extends HttpServlet {
	
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
		Connection connection = getConnection(req);
		
		if (action.startsWith("/categories")) {
			
			CategoryDAO CategoryDAO = new CategoryDAO(connection);	
			List<Category> categories = CategoryDAO.getCategories();
			
			req.setAttribute("categories", categories);
			
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if (action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			CategoryDAO CategoryDAO = new CategoryDAO(connection);
			Category choice = CategoryDAO.getCategory(categoryId);
			
			ProjectDAO ProjectDAO = new ProjectDAO(connection);	
			List<Project> projects = ProjectDAO.getProjects(new Category(categoryId));
			
			req.setAttribute("projects", projects);
			req.setAttribute("category", choice);
			
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("project"));
			
			ProjectDAO ProjectDAO = new ProjectDAO(connection);	
			Project project = ProjectDAO.getProject(projectId);
			
			req.setAttribute("project", project);
			
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		} else if (action.equals("/faq")) {
			int projectId = Integer.valueOf(req.getParameter("project"));
			
//			ProjectDAO ProjectDAO = new ProjectDAO(connection);	
//			Project project = ProjectDAO.getProject(projectId);
//			
//			req.setAttribute("project", project);
//			
//			req.getRequestDispatcher("project.jsp").forward(req, resp);
		} else if (action.equals("/payment")) {
			int projectId = Integer.valueOf(req.getParameter("project"));
			
//			ProjectDAO ProjectDAO = new ProjectDAO(connection);	
//			Project project = ProjectDAO.getProject(projectId);
//			
//			req.setAttribute("project", project);
//			
//			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI(); // TODO поискать более короткий способ сделать это
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}

	private Connection getConnection(HttpServletRequest req) {
		Connection result = (Connection)req.getSession().getAttribute("connection");
		if (result == null) {
			try {
				result = DriverManager.getConnection("jdbc:postgresql://localhost:5433/kickstarterdb","postgres","123");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			req.getSession().setAttribute("connection", result);
		}
		return result;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
	}
    
}
