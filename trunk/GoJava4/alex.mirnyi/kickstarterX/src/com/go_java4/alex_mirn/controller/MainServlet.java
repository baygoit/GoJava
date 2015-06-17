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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.go_java4.alex_mirn.dao.ConnectionPoolImpl;
import com.go_java4.alex_mirn.dao.Dao;
import com.go_java4.alex_mirn.dao.DaoImpl;
import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;

@WebServlet("/")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = getAction(req);
//		Connection connection = getConnection(req);
		
//		try {
//			Connection connection = (Connection)req.getSession().getAttribute("connection");
//			if (connection == null) {
//				connection = new ConnectionPoolImpl().getConnection();
//				req.getSession().setAttribute("connection", connection);
//			}
//			Dao repository = new DaoImpl(new Random());
			PrintWriter out = resp.getWriter();
			if (action.startsWith("/categories")) {
//				ArrayList<Category> categories = (ArrayList<Category>) repository.getAll();
//				String categoriesStr = categories.get(1).toString();
//				req.setAttribute("categories", categoriesStr);
				
//				String message = "Hello JSP";
				req.setAttribute("message", "Hello JSP");
				
				
				req.getRequestDispatcher("categories.jsp").forward(req, resp);
//				ArrayList<Project> projects = (ArrayList<Project>) repository.getAllProjects();
//				String response = categories.get(1).toString();
//				String response2 = projects.get(1).toString();
//				PrintWriter out = resp.getWriter();
//				out.println("<html>");
//				out.println("<body>");
//				out.println("<p>" + response + "</p>");
//				out.println("<p>" + response2 + "</p>");
//				out.println("</body>");
//				out.println("</html>");
			} else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Hello Alexeyushka!</h1>");
				out.println("</body>");
				out.println("</html>");
			}
			
//		} catch (SQLException e) {
//			throw new RuntimeException("Problems with creating of connection", e);
//		}
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
