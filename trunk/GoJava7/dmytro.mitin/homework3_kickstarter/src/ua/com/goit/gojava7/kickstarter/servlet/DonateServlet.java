package ua.com.goit.gojava7.kickstarter.servlet;

import ua.com.goit.gojava7.kickstarter.controller.Controller;
import ua.com.goit.gojava7.kickstarter.model.Category;
import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DonateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Project project = (Project) session.getAttribute("project");
        Category category = (Category) session.getAttribute("category");
        int categoryId = (Integer) session.getAttribute("categoryId");
        session.removeAttribute("project");
        session.removeAttribute("category");
        session.removeAttribute("categoryId");
        String sum = request.getParameter("sum");
        request.setAttribute("project", project);
        request.setAttribute("category", category);
        request.setAttribute("categoryId", categoryId);

        if (sum != null && !sum.equals("other")) {
            Controller controller = (Controller) request.getServletContext().getAttribute("controller");
            try {
                controller.donate(project, Integer.parseInt(sum));
            } catch (ExitException e) {
                // do nothing
            }
        }

        request.getRequestDispatcher("project.jsp").forward(request, response);
    }
}
