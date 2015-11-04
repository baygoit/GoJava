package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.filter.SimpleAuthFilter;
import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;
import com.donishchenko.airbnb.validation.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class MainController extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if ("/logout".equals(path)) {
            session.invalidate();

            resp.sendRedirect("/login");
            return;
        }

        if ("/".equals(path)) {
            path = "/home";
        } else if ("/search".equals(path)) {
            //TODO
        }

        String url = "/WEB-INF/views" + path + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        String url = "/WEB-INF/views" + path + ".jsp";

        if (SimpleAuthFilter.REGISTRATION_URL.equals(path)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            User user = new User(login, password, email);
            UserValidator userValidator = new UserValidator(user);
            userValidator.validate();

            if (userValidator.hasErrors()) {
                Map<String, String> errors = userValidator.getErrors();
                for (Map.Entry<String, String> error : errors.entrySet()) {
                    req.setAttribute(error.getKey(), error.getValue());
                }

                req.setAttribute("user", user);

                req.getRequestDispatcher(url).forward(req, resp);
            } else {
                try {
                    userService.register(user);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);

                    resp.sendRedirect("/");
                } catch (SQLException e) {
                    //TODO handle exception
                    req.getRequestDispatcher(url).forward(req, resp);
                    e.printStackTrace();
                }

            }
        }
        else if (SimpleAuthFilter.LOGIN_URL.equals(path)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = userService.login(login, password);
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect("/");
            } else {
                req.setAttribute("loginError", "Invalid login or password");

                req.getRequestDispatcher(url).forward(req, resp);
            }
        }
        //TODO profile.POST
    }
}
