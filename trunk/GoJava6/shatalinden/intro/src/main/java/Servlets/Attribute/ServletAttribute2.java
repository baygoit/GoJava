package Servlets.Attribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletAttribute2 extends HttpServlet{
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");

        HttpSession session = request.getSession(true);

        if (session.getAttribute("userName") == null) {
            session.setAttribute("userName", "Stranger");
        }

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body bgcolor=\"lightblue\">");
        out.println("<head>");

        out.println("<title> A session example </title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1> A session example page 2</h1>");

        out.println("Welcome " + (String) session.getAttribute("userName") + "!");

        out.println("<P><A HREF = \"ServletAttribute\">go to page 1</A>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
