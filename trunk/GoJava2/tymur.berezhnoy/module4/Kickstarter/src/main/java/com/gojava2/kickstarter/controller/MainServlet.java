 package com.gojava2.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gojava2.kickstarter.dao.CategoriesDAO;
import com.gojava2.kickstarter.dao.ProjectsDAO;
import com.gojava2.kickstarter.dao.QuotesDAO;
import com.gojava2.kickstarter.model.Category;
import com.gojava2.kickstarter.model.Project;
import com.gojava2.kickstarter.model.Quote;

public class MainServlet extends HttpServlet {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Can't load driver");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getRequestURI().substring(req.getContextPath().length());
		
		Connection connection = getConnection(req);

		if(action.equals("/categories")) {
			QuotesDAO quoteDAO = new QuotesDAO(connection);
			
			Quote quote = quoteDAO.getRandomQuote();
			StringBuilder builder = new StringBuilder();
			builder.append("\"").append(quote.getContent()).append("\"")
			.append(quote.getCopyrightSymbol()).append(quote.getAuthor());
			
			CategoriesDAO categoryDAO = new CategoriesDAO(connection);
			LinkedHashSet<Category> categories = categoryDAO.getCategories();
			
			req.setAttribute("quote", quote);
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if(action.equals("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("categoryId"));
			String categoryName = String.valueOf(req.getParameter("categoyName"));
			
			ProjectsDAO projectDAO = new ProjectsDAO(connection);
			List<Project> projects = projectDAO.getProjects(new Category(categoryId, categoryName));
			
			req.setAttribute("projects", projects);
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if(action.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));
			
			ProjectsDAO projectDAO = new ProjectsDAO(connection);
			Project project = projectDAO.getProject(projectId);
			
			req.setAttribute("project", project);
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}
	}
	
	private Connection getConnection(HttpServletRequest req) {
		Connection result = (Connection) req.getSession().getAttribute("connection");
		if(result == null) {
			try {
				result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter",
						"postgres", "Berezhnoi");
			} catch (SQLException e) {
				throw new RuntimeException("Can't get connection", e);
			}
			req.getSession().setAttribute("connection", result);
		}
		return result;
	}
}