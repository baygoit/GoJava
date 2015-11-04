package com.azuiev.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Masta on 17.10.2015.
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String path = req.getServletPath();
        if ("/login".equals(path)){

        }
        req.getRequestDispatcher(context.getInitParameter("path")+path+".jsp").forward(req, resp);

    }

}
