package com.gojava6;

// Import java libraries

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/ServletDemoPath"})
public class ServletDemo extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "Hell no! This is Tomcaaaaat Hello-World page!";
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println(message);
        out.println("Hello, " + userName + " " + userSurname + "!");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        out.println("Hello, " + userName + " " + userSurname);
    }

    public void destroy() {
        // do nothing.
    }
}
