package MyAirBnB.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by macmini on 20.10.15.
 */
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);

       // req.setAttribute("name", "Devcolibri");

        //req.getRequestDispatcher("mypage.jsp").forward(req, resp);

       PrintWriter out = resp.getWriter();
        out.print("<h1>Hello Servlet</1h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);


    }
}
