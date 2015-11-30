package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;

@WebServlet("/message")
public class SendMessage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("id"));

        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle("Leave a message");
        htmlPageWriter.addControl("hidden", "projectId", String.valueOf(projectId));
        htmlPageWriter.addControl("hidden", "operation", "message");
        htmlPageWriter.addControl("text", "user", "User");
        htmlPageWriter.addControl("textarea", "message", "Message");
        htmlPageWriter.addControl("submit", "submit", "Submit");
        htmlPageWriter.setAction("project");

        response.getWriter().print(htmlPageWriter.prepare());
    }

}
