package com.gojava6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>My Title!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Hello World! Next</h2>");
        out.println("</body>");
        out.println("</html>");
    }
}
