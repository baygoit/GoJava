package com.gojava6.airbnb.servlets;

import com.gojava6.airbnb.dao.userDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("city");
        String name = request.getParameter("min_price");
        String surname = request.getParameter("max_price");
        userDao.pushUser(name, surname, email);

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/get_all_users.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
