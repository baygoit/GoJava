package ua.com.goit.gojava.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.kickstarter.dao.CategoriesDao;
import ua.com.goit.gojava.kickstarter.dao.ConnectionPool;
import ua.com.goit.gojava.kickstarter.dao.ProjectsDao;
import ua.com.goit.gojava.kickstarter.data.Category;
import ua.com.goit.gojava.kickstarter.data.Project;



public class MainServlet extends HttpServlet {
   
	static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestUrl = req.getRequestURI();
		String request = requestUrl.substring(req.getContextPath().length(), requestUrl.length());
		
		ConnectionPool pool = new ConnectionPool();
		Connection connection = pool.getConnection();
		CategoriesDao categoriesDao = new CategoriesDao(connection);
		ProjectsDao projectsDao = new ProjectsDao (connection);
		
		if(request.startsWith("/categories")){
			List<Category> categories = categoriesDao.getCatalog(); 
		  
		  req.setAttribute("catalog", categories);
		  req.getRequestDispatcher("catalog.jsp").forward(req,resp); 
		 
		} else if (request.startsWith("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			
			List<Project> projects = projectsDao.getProjects(categoriesDao.getCategory(categoryId));

			req.setAttribute("projects", projects);

			req.getRequestDispatcher("/projects.jsp").forward(req, resp);
		} else if (request.equals("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));

			Project project = projectsDao.getProject(projectId);

			req.setAttribute("project", project);

			req.getRequestDispatcher("/project.jsp").forward(req, resp);
		}
		
	}

	
	 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println(req.getParameterMap().toString());
	    }


}
