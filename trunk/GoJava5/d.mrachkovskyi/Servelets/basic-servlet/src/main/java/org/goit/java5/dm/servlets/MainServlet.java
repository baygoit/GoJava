package org.goit.java5.dm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/10/15
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String responseStr;
        String username = request.getParameter("username");
        if (StringUtils.isNotBlank(username)) {
            responseStr = "Hello " + username;
        } else {
            responseStr = "Hello, whoever you are";
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>This is servlet</h1>");
        out.println("<h2>" + responseStr + "</h2>");
        out.println("</body>");
        out.println("</html>");
    }

}
