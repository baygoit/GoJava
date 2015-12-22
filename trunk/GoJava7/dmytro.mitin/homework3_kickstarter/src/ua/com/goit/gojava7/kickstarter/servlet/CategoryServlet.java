package ua.com.goit.gojava7.kickstarter.servlet;

import ua.com.goit.gojava7.kickstarter.model.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categories = (List<Category>) request.getServletContext().getAttribute("categories");
        Category category = categories.get(id);
        request.setAttribute("category", category);
        request.setAttribute("categoryId", id);

        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
}
