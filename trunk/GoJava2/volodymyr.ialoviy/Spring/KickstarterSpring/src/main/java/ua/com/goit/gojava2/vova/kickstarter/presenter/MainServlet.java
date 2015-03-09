package ua.com.goit.gojava2.vova.kickstarter.presenter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava2.vova.kickstarter.model.CategoriesDAO;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.ProjectsDAO;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static{
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
		
		if(action.startsWith("/categories")){
			CategoriesDAO categoriesFromDB = new CategoriesDAO(connection);
			List<Category> categories = categoriesFromDB.getCategories();
			
			req.setAttribute("categories", categories);
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if (action.startsWith("/projects")){
			int categoryID = Integer.valueOf(req.getParameter("category"));
			
			ProjectsDAO projectsFromDB = new ProjectsDAO(connection);
			List<Project> projects = projectsFromDB.getProgectsForCategory(categoryID);
			
			req.setAttribute("projects", projects);
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.startsWith("/project")){
		int projectID = Integer.valueOf(req.getParameter("project"));
		
		ProjectsDAO projectsFromDB = new ProjectsDAO(connection);
		Project project = projectsFromDB.getProgect(projectID);

		req.setAttribute("project", project);
		req.getRequestDispatcher("project.jsp").forward(req, resp);
		}
		
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
		return action;
	}

	private Connection getConnection(HttpServletRequest req) {
		Connection rezult = (Connection)req.getSession().getAttribute("connection");
		if (rezult == null){
			try {
				rezult = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/kickstarter", "postgres", "7575");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			req.getSession().setAttribute("connection", rezult);
		}
		return rezult;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
	}

}

