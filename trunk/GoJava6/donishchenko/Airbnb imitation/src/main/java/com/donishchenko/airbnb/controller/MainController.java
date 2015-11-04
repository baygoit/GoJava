package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.filter.SimpleAuthFilter;
import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;
import com.donishchenko.airbnb.validation.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.*;
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

        if ("/registration".equals(path)) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            User user = new User(login, password, email);
            UserValidator userValidator = new UserValidator();

            userValidator.validateLogin(login);
            userValidator.validatePassword(password);
            userValidator.validateEmail(email);

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
        else if ("/profile".equals(path)) {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            String email = req.getParameter("email");

            UserValidator userValidator = new UserValidator();
            userValidator.validateName(name);
            userValidator.validateSurname(surname);
            userValidator.validateEmail(email);

            if (userValidator.hasErrors()) {
                Map<String, String> errors = userValidator.getErrors();
                for (Map.Entry<String, String> error : errors.entrySet()) {
                    req.setAttribute(error.getKey(), error.getValue());
                }

                req.getRequestDispatcher(url).forward(req, resp);
            } else {
                HttpSession session = req.getSession();

                User user = (User) session.getAttribute("user");
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);

                userService.updateUser(user.getId(), user);

                req.setAttribute("success", "Successfully");

                req.getRequestDispatcher(url).forward(req, resp);
            }
        }
    }
}
