package com.shcherbak.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorldExample extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");

        out.println("<title>" + "title" + "</title>");
        out.println("</head>");
        out.println("<body >");
        out.println("Next Test Servlet");
        out.println("Next Test Servlet");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}



