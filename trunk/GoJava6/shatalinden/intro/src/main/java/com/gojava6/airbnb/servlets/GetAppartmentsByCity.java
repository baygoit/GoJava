package com.gojava6.airbnb.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAppartmentsByCity extends HttpServlet {
    public static String city;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        city = request.getParameter("city");

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/apartment_search_result.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}