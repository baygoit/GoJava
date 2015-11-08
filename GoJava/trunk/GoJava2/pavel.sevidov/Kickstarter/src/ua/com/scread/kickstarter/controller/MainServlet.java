package ua.com.scread.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import ua.com.scread.kickstarter.dao.CategoriesDAO;
import ua.com.scread.kickstarter.dao.ProjectsDAO;
import ua.com.scread.kickstarter.data.Category;
import ua.com.scread.kickstarter.data.Project;

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
            
            CategoriesDAO categoriesDAO = new CategoriesDAO(connection);    
            List<Category> categories = categoriesDAO.getCategories();
            
            req.setAttribute("categories", categories);
            
            req.getRequestDispatcher("categories.jsp").forward(req, resp);
        } else if (action.equals("/projects")) {
            int categoryId = Integer.valueOf(req.getParameter("category"));
            
            ProjectsDAO projectsDAO = new ProjectsDAO(connection);  
            List<Project> projects = projectsDAO.getProjects(new Category(categoryId));
            
            req.setAttribute("projects", projects);
            
            req.getRequestDispatcher("projects.jsp").forward(req, resp);
        } else if (action.equals("/project")) {
            int projectId = Integer.valueOf(req.getParameter("id"));
            
            ProjectsDAO projectsDAO = new ProjectsDAO(connection);  
            Project project = projectsDAO.get(projectId);
            
            req.setAttribute("project", project);
            
            req.getRequestDispatcher("project.jsp").forward(req, resp);
        } else if (action.equals("/payment")) {
            int projectId = Integer.valueOf(req.getParameter("id"));
            
            ProjectsDAO projectsDAO = new ProjectsDAO(connection);
            Project project = projectsDAO.get(projectId);
            
            req.setAttribute("payment", project);
            
            req.getRequestDispatcher("payment.jsp").forward(req, resp);
        }
    }

    private String getAction(HttpServletRequest req) {
        String requestURI = req.getRequestURI(); 
        String action = requestURI.substring(req.getContextPath().length(), requestURI.length());
        return action;
    }

    private Connection getConnection(HttpServletRequest req) {
        Connection result = (Connection)req.getSession().getAttribute("connection");
        if (result == null) {
            try {
                result = DriverManager.getConnection("jdbc:postgresql://localhost:5432/kickstarter", "postgres", "1234");
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

