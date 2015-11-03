package com.gojava6.airbnb.controller;

import com.gojava6.airbnb.apartment.Apartment;
import com.gojava6.airbnb.services.ApartmentService;
import com.gojava6.airbnb.services.UserService;
import com.gojava6.airbnb.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getServletPath();

        if (url.equals("/IndexServlet")) {
            HttpSession session = request.getSession();
            if (session != null) {
                session.removeAttribute("greeting");
                session.removeAttribute("userPage");
                session.removeAttribute("log");
                session.removeAttribute("logServlet");
                session.removeAttribute("userAction");
                session.removeAttribute("userActionServlet");
                session.invalidate();
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (url.equals("/GetAllUsersServlet")) {

            List<User> users = UserService.getAllUsers();
            request.setAttribute("usersList", users);
            request.getRequestDispatcher("get_all_users.jsp").forward(request, response);
        }

        if (url.equals("/GetAppartmentsByCity")) {

            List<Apartment> apartments = ApartmentService.pullApartmentsByCity(request.getParameter("city"));
            request.setAttribute("apartmentsList", apartments);
            request.setAttribute("cityList", apartments);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/apartment_search_result.jsp");
            dispatcher.forward(request, response);
        }

        if (url.equals("/login")) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = UserService.getUserByEmail(email);

            if (password.equals(user.getPassword())) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                String greeting = "Profile " + user.getName();
                session.setAttribute("greeting", greeting);
                session.setAttribute("userPage", "user_page.jsp");
                session.setAttribute("log", "Logout");
                session.setAttribute("logServlet", "IndexServlet");
                if(!user.getBooleanUserType()) {
                    session.setAttribute("userAction", "Become a host");
                    session.setAttribute("userActionServlet", "become_host");
                } else {
                    session.setAttribute("userAction", "Create an apartment");
                    session.setAttribute("userActionServlet", "create_apartment.jsp");
                }

                request.getRequestDispatcher("user_page.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

        if (url.equals("/Registration")) {

            String email = request.getParameter("check_in_date");
            String password = request.getParameter("check_out_date");
            String name = request.getParameter("min_price");
            String surname = request.getParameter("max_price");
            User user = new User(name, surname, email, password);
            UserService.writeUserToDB(user);
            user = UserService.getUserByEmail(email);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            String greeting = "Profile " + user.getName();
            session.setAttribute("greeting", greeting);
            session.setAttribute("userPage", "user_page.jsp");
            session.setAttribute("log", "Logout");
            session.setAttribute("logServlet", "IndexServlet");
            session.setAttribute("userAction", "Become a host");
            session.setAttribute("userActionServlet", "become_host");

            request.getRequestDispatcher("user_page.jsp").forward(request, response);
        }

        if (url.equals("/become_host")) {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            UserService.changeClientToHost(user);

            session.setAttribute("userAction", "Create an apartment");
            session.setAttribute("userActionServlet", "create_apartment.jsp");
            request.getRequestDispatcher("user_page.jsp").forward(request, response);
        }

        if (url.equals("/CreateAnApartment")) {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            String type = request.getParameter("type");
            String city = request.getParameter("city");
            int price = Integer.parseInt(request.getParameter("price"));
            String shortDescription = request.getParameter("short_description");
            Apartment apartment = new Apartment(0, city, type, user.getUserID(), price, shortDescription);
            ApartmentService.pushApartment(apartment);
            request.getRequestDispatcher("/user_page.jsp").forward(request, response);
        }

        if (url.equals("/deleteUser")) {

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            UserService.deleteUserFromDB(user);

            request.getRequestDispatcher("IndexServlet").forward(request, response);
        }

        if (url.equals("/GetUserApartments")) {

            HttpSession session = request.getSession();

            request.setAttribute("apartmentsList", ApartmentService.pullApartmentsByUserID((int) session.getAttribute("userID")));
            RequestDispatcher dispatcher = request.getRequestDispatcher("/apartment_search_result.jsp");
            dispatcher.forward(request, response);
        }

        if (url.equals("/login_page")) {
            request.getRequestDispatcher("login_page.jsp").forward(request, response);
        }

        if (url.equals("/registration_page")) {
            request.getRequestDispatcher("registration_page.jsp").forward(request, response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
