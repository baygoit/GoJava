package Servlets.Attribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletAttribute1 extends HttpServlet{
    HttpSession session;

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html");

        // session is retrieved before getting the writer

        session = request.getSession(true);

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

        out.println("<h1> A session example page 1</h1>");

        out.println("<P>");
        out.print("<form action=\"");
        out.print(response.encodeURL("ServletAttribute"));
        out.print("\" ");
        out.println("method=POST>");
        out.println("What's your name?");
        out.println("<br>");
        out.println("<input type=text size=20 name=myname>");
        out.println("<br>");
        out.println("<input type=submit>");
        out.println("</form>");

        out.println("Welcome " + (String) session.getAttribute("userName") + "!");

        out.println("<P><A HREF = \"/ServletApp/ServletAttribute2\">go to page 2</A>");

        out.println("</body>");
        out.println("</html>");

        out.close();

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException
    {
        session = request.getSession(true);
        session.setAttribute("userName", request.getParameter("myname"));
        doGet(request, response);
    }
}
