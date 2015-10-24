package com.gojava6;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getInitParameter("foo");
        String firstName = req.getParameter("first_name");
        if (firstName == null || firstName.isEmpty()) {
            req.setAttribute("errors", "firstname");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/register");
            requestDispatcher.forward(req, resp);
        }
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>user with last name: " + req.getParameter("last_name") + "</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Add user get: " + req.getParameter("id"));
        writer.close();
    }
}
