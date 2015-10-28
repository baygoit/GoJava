package com.go_java4.alex_mirn.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.go_java4.alex_mirn.dao.ConnectionPoolImpl;
import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.dao.DaoImpl;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;

//@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = getAction(req);
//		Connection connection = getConnection(req);
		
		try {
//			Connection connection = (Connection)req.getSession().getAttribute("connection");
			Dao repository = (Dao)req.getSession().getAttribute("connection");
//			Dao repository = new DaoImpl(new Random());;
//			if (connection == null) {
			if (repository == null) {
				repository = new DaoImpl(new Random());
//				connection = new ConnectionPoolImpl().getConnection();
				req.getSession().setAttribute("connection", repository);
//				req.getSession().setAttribute("connection", connection);
			}
			PrintWriter out = resp.getWriter();
			if (action.startsWith("/categories")) {
				Quote quote = (Quote) repository.getRandomQuote();
				req.setAttribute("quote", quote);
				ArrayList<Category> categories = (ArrayList<Category>) repository.getAll();
				req.setAttribute("categories", categories);
				req.getRequestDispatcher("categories.jsp").forward(req, resp);
			} else if (action.startsWith("/projects")) {
				int categoryId = Integer.valueOf(req.getParameter("category"));
				ArrayList<Project> projects = (ArrayList<Project>) repository.getProjectsInCategory(categoryId);
				req.setAttribute("projects", projects);
				req.getRequestDispatcher("projects.jsp").forward(req, resp);
			} else if (action.startsWith("/oneProject")) {
				int projectId = Integer.valueOf(req.getParameter("project"));
				Project project = (Project) repository.getProjectIndex(projectId);
				req.setAttribute("oneProject", project);
				req.getRequestDispatcher("oneProject.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Problems with creating of connection", e);
		}
	}

//	private Connection getConnection(HttpServletRequest req) {
//		
//	}

	private String getAction(HttpServletRequest req) {
		String requestUri = req.getRequestURI();
		String action = requestUri.substring(req.getContextPath().length(), requestUri.length());
		return action;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet!!!</h1>");
		out.println("</body>");
		out.println("</html>");	
	}
	
}
