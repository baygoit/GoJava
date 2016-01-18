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

public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Project project = (Project) session.getAttribute("project");
        Category category = (Category) session.getAttribute("category");
        int categoryId = (Integer) session.getAttribute("categoryId");
        session.removeAttribute("project");
        session.removeAttribute("category");
        session.removeAttribute("categoryId");
        String question = request.getParameter("question");
        Controller controller = (Controller) request.getServletContext().getAttribute("controller");
        if (question != null && question.length() > 0) {
            try {
                controller.askQuestion(project, question);
            } catch (ExitException e) {
                // do nothing
            }
        }

        request.setAttribute("project", project);
        request.setAttribute("category", category);
        request.setAttribute("categoryId", categoryId);

        request.getRequestDispatcher("project.jsp").forward(request, response);
    }
}
