package Servlets.HttpSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n = request.getParameter("userName");
            out.print("Welcome " + n);

            HttpSession session = request.getSession();
            session.setAttribute("uname", n);

            out.print("<a href='servlet2'> <br> Go to your profile page </a>");

            out.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
