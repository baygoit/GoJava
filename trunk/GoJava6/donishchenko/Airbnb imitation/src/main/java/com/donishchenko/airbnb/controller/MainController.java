package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.dao.JdbcUserDao;
import com.donishchenko.airbnb.dao.UserDao;
import com.donishchenko.airbnb.filter.SimpleAuthFilter;
import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MainController extends HttpServlet {

    private UserDao userDao = new JdbcUserDao();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if (path.equals("/")) {
            path = "/home";
        }

        String url = "/WEB-INF/views" + path + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        HttpSession session = req.getSession(false);

        if (SimpleAuthFilter.LOGIN_URL.equals(path)) {

        }


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

            try {
                userDao.update(user.getId(), user);
            } catch (SQLException e) {
                //TODO handle exception
                e.printStackTrace();
            }

            resp.sendRedirect("/");
        } else if (path.equals("/registration")) {
            String login = req.getParameter("login");
            String surname = req.getParameter("surname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User(login, surname, email);
            if (user.validate()) {
                try {
                    int userId = userDao.save(user);
                    user.setId(userId);

                    session.setAttribute("user", user);

                    resp.sendRedirect("/");
                } catch (SQLException ex) {
                    //TODO handle exception
                }
            }
        }
    }
}
