package org.goit.java5.dm.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 8/10/15
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (StringUtils.isBlank(name)) {
            name =  "Anonymous";
        }

        String surname = request.getParameter("surname");
        if (StringUtils.isBlank(name)) {
            surname =  "Anonymous";
        }
        request.setAttribute("name", name);
        request.setAttribute("surname", surname);

        request.getRequestDispatcher("helloResponse.jsp").forward(request, response);

    }
}
