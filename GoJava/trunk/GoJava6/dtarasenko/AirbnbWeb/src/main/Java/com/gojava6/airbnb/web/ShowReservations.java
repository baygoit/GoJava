package com.gojava6.airbnb.web;

import com.gojava6.airbnb.model.Reservation;
import com.gojava6.airbnb.services.ReservationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowReservations extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ReservationService reservationService = (ReservationService) context.getBean("reservationService");
        List<Reservation> reservationList = reservationService.getReservationList();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">\n" +
                "\t<title>Admin page</title>\n" +
                "\t<link rel=\"stylesheet\" href=\"css\\reset.css\">\n" +
                "\t<link rel=\"stylesheet\" href=\"css\\style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "\t\n" +
                "\t<div class=\"wrap\">\n" +
                "\t\t<header>\n" +
                "\t\t\t<h1><a href=\"http://localhost:8080/AirbnbWeb/\">airbnb</a></h1>\n" +
                "\t\t\t\t<ul class=\"menu\">\n" +
                "\t\t\t\t<li><a href=\"http://localhost:8080/AirbnbWeb/signup.html\">Sign Up</a></li>\n" +
                "\t\t\t\t<li><a href=\"http://localhost:8080/AirbnbWeb/client.html\">Client page</a></li>\n" +
                "\t\t\t\t<li><a href=\"http://localhost:8080/AirbnbWeb/host.html\">Host page</a></li>\n" +
                "\t\t\t\t<li><a href=\"http://localhost:8080/AirbnbWeb/admin.html\">Admin</a></li>\n" +
                "\t\t\t</ul>\n" +
                "\t\t\t\n" +
                "\t\t</header>\n" +
                "\n" +
                "\t\t\t\n" +
                "\t\t<section>\n");

        for (Reservation reservation : reservationList) {
            out.println("<p>" + reservation.toString() + "</p>");
        }

        out.println("\t\t</section>\n" +
                "\t\t\n" +
                "\t\t<footer>\n" +
                "\t\t</footer>\n" +
                "\t</div>\n" +
                "\t\n" +
                "</body>\n" +
                "</html>");
    }
}
