package com.azuiev.servlet;

import com.azuiev.model.User;
import com.azuiev.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Masta on 17.10.2015.
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = getServletContext();
        String path = request.getServletPath();
        request.getRequestDispatcher(context.getInitParameter("path")+path+".jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String path = request.getServletPath();
        if ("/login".equals(path)){
            String email = (String)request.getParameter("email");
            String password = (String)request.getParameter("password");
            UserService userService = new UserService();
            User user = userService.login(email, password);
            if (user==null) {
                request.getRequestDispatcher(context.getInitParameter("path")+path+".jsp").forward(request, response);
                response.sendError(1);
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

        }
        response.sendRedirect("search");

    }
}
