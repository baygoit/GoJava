package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.dao.JdbcUserDao;
import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainController extends HttpServlet {

    private UserDao userDao = new JdbcUserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        HttpSession session = req.getSession();

        if (path.equals("/")) {
            path = "/home";
        }

        String url = "/WEB-INF/views" + path + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO test post

        String path = req.getServletPath();
        HttpSession session = req.getSession();

        if (path.equals("/login")) {
            String login = (String) req.getParameter("login");
            String password = (String) req.getParameter("password");
            User user = new User(login, password, "test@test.com");

            session.setAttribute("user", user);
            resp.sendRedirect("/");
        } else if (path.equals("/edituser")) {
            String login = (String) req.getParameter("login");
            String surname = (String) req.getParameter("surname");
            String email = (String) req.getParameter("email");
            User user = (User) session.getAttribute("user");
            user.setName(login);
            user.setSurname(surname);
            user.setEmail(email);

            resp.sendRedirect("/");
        }

//        String url = "/WEB-INF/views" + path + ".jsp";

//        req.getRequestDispatcher(url).forward(req, resp);
    }
}
