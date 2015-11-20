package com.donishchenko.airbnb.controller;

import com.donishchenko.airbnb.model.Apartment;
import com.donishchenko.airbnb.model.City;
import com.donishchenko.airbnb.model.User;
import com.donishchenko.airbnb.services.SearchService;
import com.donishchenko.airbnb.services.UserService;
import com.donishchenko.airbnb.validation.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MainController extends HttpServlet {

    private UserService userService     = new UserService();
    private SearchService searchService = new SearchService();
//    private List<City> availableCities  = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();

        List<City> availableCities = searchService.getAllCities();
        getServletContext().setAttribute("availableCities", availableCities);
    }

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
            //TODO search
            Map<String, String[]> params = req.getParameterMap();
            if (params.size() != 0) {
                /* Search */
                String city = params.keySet().iterator().next();

                List<Apartment> apartments = searchService.getAllApartmentsByCity(city);
                req.setAttribute("apartments", apartments);
            }
        }

        String url = "/WEB-INF/views" + path + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getServletPath();
        String url = "/WEB-INF/views" + path + ".jsp";

        /* Registration */
        if ("/registration".equals(path)) {
            String login    = req.getParameter("login");
            String password = req.getParameter("password");
            String email    = req.getParameter("email");

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
                userService.register(user);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect("/");
            }
        }
        /* Login */
        else if ("/login".equals(path)) {
            String login    = req.getParameter("login");
            String password = req.getParameter("password");

            if (login.isEmpty() || password.isEmpty()) {
                req.setAttribute("loginError", "Invalid login or password");

                req.getRequestDispatcher(url).forward(req, resp);
                return;
            }

            User user = userService.login(login, password);
            if (user == null) {
                req.setAttribute("loginError", "Invalid login or password");

                req.getRequestDispatcher(url).forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                resp.sendRedirect("/");
            }
        }
        /* Profile */
        else if ("/profile".equals(path)) {
            String email    = req.getParameter("email");
            String name     = req.getParameter("name");
            String surname  = req.getParameter("surname");

            UserValidator userValidator = new UserValidator();
            userValidator.validateEmail(email);
            userValidator.validateName(name);
            userValidator.validateSurname(surname);

            if (userValidator.hasErrors()) {
                Map<String, String> errors = userValidator.getErrors();
                for (Map.Entry<String, String> error : errors.entrySet()) {
                    req.setAttribute(error.getKey(), error.getValue());
                }

                req.getRequestDispatcher(url).forward(req, resp);
            } else {
                HttpSession session = req.getSession();

                //TODO maybe save old values if fail update
                User user = (User) session.getAttribute("user");
                user.setEmail(email);
                user.setName(name);
                user.setSurname(surname);

                userService.updateUser(user);

                req.setAttribute("updateMessage", "Successfully");

                req.getRequestDispatcher(url).forward(req, resp);
            }
        }
    }
}
