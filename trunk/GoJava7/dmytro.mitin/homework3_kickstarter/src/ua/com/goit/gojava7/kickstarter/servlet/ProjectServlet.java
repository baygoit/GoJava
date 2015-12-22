package ua.com.goit.gojava7.kickstarter.servlet;

import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        List<Category> categories = (List<Category>) request.getServletContext().getAttribute("categories");
        Category category = categories.get(categoryId);
        Project project = category.getProjects().get(id);
        request.setAttribute("project", project);
        request.setAttribute("category", category);
        request.setAttribute("categoryId", categoryId);

        request.getRequestDispatcher("project.jsp").forward(request, response);

    }
}
