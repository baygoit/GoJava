package com.shcherbak.web.old;/*
package com.shcherbak.web;

import com.shcherbak.model.old.Apartment;
import com.shcherbak.processing.SQLProcessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String doIt = request.getParameter("doIt");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        List<Apartment> apartments = null;
        SQLProcessor processor = new SQLProcessor("jdbc:mysql://localhost:3306/airbnb", "root", "atmel");
        processor.openDataBase();
        apartments = processor.getApartments();
        //apartments = processor.getApartments("Kiev", RentType.APARTMENT);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>user with first name: " + request.getParameter("name") + "</h2>");
        out.println("<h2>user with last name: " + request.getParameter("surname") + "</h2>");
        out.println("<p><br>user : " + name + "  " + surname +  "</p><br>");

        for (Apartment ap: apartments) {
            out.println(ap + "<br>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
        processor.closeDataBase();
    }

   */
/* @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Add user get: " + req.getParameter("id"));
        writer.close();
    }*//*

}
*/
