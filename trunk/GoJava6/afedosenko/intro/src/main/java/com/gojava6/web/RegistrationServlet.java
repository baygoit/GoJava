package com.gojava6.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sergiigetman on 10/11/15.
 */
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getInitParameter("url");
        //resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Registration Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/addUser\" method=\"post\">\n" +
                "    First name:  <input type=\"text\" name=\"first_name\" />\n" +
                "    <br>\n" +
                "    Last name:  <input type=\"text\" name=\"last_name\" />\n" +
                "    <p><input type=\"submit\"></p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

        out.close();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Registration Form</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p> incorrect fields: " +
                 (String) req.getAttribute("errors") +
                "<form action=\"/addUser\" method=\"post\">\n" +
                "    First name:  <input type=\"text\" name=\"first_name\" />\n" +
                "    <br>\n" +
                "    Last name:  <input type=\"text\" name=\"last_name\" />\n" +
                "    <p><input type=\"submit\"></p>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }
}
