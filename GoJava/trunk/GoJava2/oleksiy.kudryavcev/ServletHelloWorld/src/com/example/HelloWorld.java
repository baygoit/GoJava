package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello World (or some another simple text)";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>\n");
        out.println("<body bgcolor=\"#adfde6\">\n");
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>Time on server: " + new Date() + " </h2>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
    }
}
