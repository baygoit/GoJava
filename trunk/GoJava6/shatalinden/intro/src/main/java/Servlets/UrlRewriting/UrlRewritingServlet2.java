package Servlets.UrlRewriting;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class UrlRewritingServlet2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    try{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //getting value from the query string
        String n=request.getParameter("uname");
        out.print("Hello "+n);

        out.close();

    }catch(Exception e){System.out.println(e);}
    }
}
