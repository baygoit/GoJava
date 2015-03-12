package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import model.CategoriesDAO;
import model.Category;
import model.Project;
import model.ProjectsDAO;

public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = getAction(request);
        
        ConnectionToDB connectToDB = new ConnectionToDB();
        Connection connection = connectToDB.getConnection("jdbc:postgresql://127.0.0.1/kickstarter", "postgres", "pass");

        // TODO refactoring to polymorph
        if (action.startsWith("/categories")) {
            CategoriesDAO categoriesDAO = new CategoriesDAO(connection);
            LinkedList<Category> categories = categoriesDAO.getCategoriesList();

            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/categories.jsp").forward(request,
                    response);
        } else if (action.startsWith("/projects")) { 
            ProjectsDAO projectsDAO = new ProjectsDAO(connection);
            int categoryId = Integer.valueOf(request.getParameter("category"));
            LinkedList<Project> projects = projectsDAO
                    .getProjectsList(categoryId);

            request.setAttribute("projects", projects);
            request.getRequestDispatcher("/projects.jsp").forward(request,
                    response);
        }

    }

    private String getAction(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String action = requestURI.substring(request.getContextPath().length(),
                requestURI.length());
        return action;
    }
}
