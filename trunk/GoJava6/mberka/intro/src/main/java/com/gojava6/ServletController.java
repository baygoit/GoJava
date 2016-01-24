package com.gojava6;

import com.gojava6.airbnb.dao.AptDAO;
import com.gojava6.airbnb.dao.UserDAO;
import com.gojava6.airbnb.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//@WebServlet(urlPatterns = {"/ServletController"})
public class ServletController extends HttpServlet {

    public void init() throws ServletException {
        AptDAO aptDAO = new AptDAO();
        List<String> allCities = aptDAO.getAllAptCities();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/CitiesController")) {
            AptDAO aptDAO = new AptDAO();
            List<String> allCities = aptDAO.getAllAptCities();
            request.setAttribute("allCities", allCities);
            request.getRequestDispatcher("/cities.jsp").forward(request, response);
        }

        if (userPath.equals("/BecomeHostController")) {
            if (request.getParameter("answer").equals("YES")) {
                response.sendRedirect("createHost.jsp");
            } else {
                response.sendRedirect("index.jsp");
            }
        }

        if (userPath.equals("/CreateHostController")) {
            HttpSession userSession = request.getSession();
            Integer idUser = (Integer) userSession.getAttribute("idUser");
            Date startDate = null;
            Date endDate = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            try {
                startDate = dateFormat.parse(request.getParameter("startDate"));
                endDate = dateFormat.parse(request.getParameter("endDate"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            AptDAO aptDAO = new AptDAO();
            aptDAO.addNewApartment((int) idUser,
                    request.getParameter("aptCity"),
                    request.getParameter("aptType"),
                    sqlStartDate, sqlEndDate);

            /*UserDAO userDAO = new UserDAO();
            userDAO.findUserById(idUser);
            User user1 = new User();
            user1.setHostUser(true);*/


        }
        if (userPath.equals("/ReservationsController")) {
            AptDAO aptDAO = new AptDAO();
            aptDAO.getAllApartments();
        }

        if (userPath.equals("/AvailableAptsController")) {
            AptDAO aptDAO = new AptDAO();
            List<List<String>> allApts = aptDAO.getAllApartments();
            List<String> allApts1 = new ArrayList<>();
            allApts1.add(allApts.toString());
            request.setAttribute("allApts", allApts1);
            request.getRequestDispatcher("/reservations.jsp").forward(request, response);

           /* response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("TEST");*/
        }

    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        if (userPath.equals("/RegistrationController")) {
            HttpSession userSession = request.getSession();
            userSession.setAttribute("userName", request.getParameter("userName"));
            userSession.setAttribute("userSurname", request.getParameter("userSurname"));

            User user1 = new User(request.getParameter("userName"),
                    request.getParameter("userSurname"),
                    request.getParameter("email"),
                    request.getParameter("userCity"));
            UserDAO userDAO = new UserDAO();
            userDAO.addNewUser(user1);

            Integer idUser = userDAO.findUserIdByEmail(request.getParameter("email"));

            /*response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("Congratulations! "
                    + request.getParameter("userName") + " "
                    + request.getParameter("userSurname") +
                    " was registered!");*/

            userSession.setAttribute("idUser", idUser);

            response.sendRedirect("becomeHost.jsp");
        }
    }

    public void destroy() {

    }
}
