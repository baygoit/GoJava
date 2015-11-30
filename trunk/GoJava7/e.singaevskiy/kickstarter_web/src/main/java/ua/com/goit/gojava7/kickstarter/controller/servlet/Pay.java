package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.controller.servlet.util.HtmlPageWriter;

@WebServlet("/payment")
public class Pay extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int projectId = Integer.parseInt(request.getParameter("project"));
        int rewardId = 0;
        if (request.getParameter("reward") != null) {
            rewardId = Integer.parseInt(request.getParameter("reward")); 
        }        

        HtmlPageWriter htmlPageWriter = new HtmlPageWriter();
        htmlPageWriter.setTitle("Pay");
        htmlPageWriter.addControl("hidden", "projectId", String.valueOf(projectId));
        htmlPageWriter.addControl("hidden", "rewardId", String.valueOf(rewardId));        
        htmlPageWriter.addControl("hidden", "operation", "payment");
        htmlPageWriter.addControl("User", "text", "user", "User");
        htmlPageWriter.addControl("Card ID", "number", "cardId", "Card ID");
        htmlPageWriter.addControl("Amount", "number", "amount", request.getParameter("amount"));
        htmlPageWriter.addControl("submit", "submit", "Submit");
        htmlPageWriter.setAction("project");

        response.getWriter().print(htmlPageWriter.prepare());
    }

}
