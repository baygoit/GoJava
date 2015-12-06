package com.airbnb;

import com.airbnb.model.Apartment;
import com.airbnb.model.User;
import com.airbnb.services.AdminService;
import com.airbnb.services.ApartamentService;
import com.airbnb.services.ReservationDatesService;
import com.airbnb.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Игорь on 25.10.2015.
 */
public class ControllerServlet extends HttpServlet{
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    UserService userService = (UserService) context.getBean("userService");
    ApartamentService apartamentService = (ApartamentService) context.getBean("apartamentService");
    ReservationDatesService reservationDatesService = (ReservationDatesService) context.getBean("reservationDatesService");
    AdminService adminService = (AdminService) context.getBean("adminService");
    //NewsSubscribeService newsSubscribeService = (NewsSubscribeService) context.getBean("newsSubscribeService");

    List<Apartment> apartments = apartamentService.getAllApartments();
    List<User> users = userService.getAllUsers();

    public void init() throws ServletException {
        Set<String> cities = apartamentService.getCitiesSet();
        getServletContext().setAttribute("cities", cities);
        getServletContext().setAttribute("sign", "Sign in");
        getServletContext().setAttribute("login", "login");
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Search search = new Search();
        HttpSession session = request.getSession(false);
        String userPath = request.getServletPath();
        List<Apartment> searchedApartments;

        try {
            if (userPath.equals("/login")) {
                request.getRequestDispatcher("/WEB-INF/planeview" + userPath + ".jsp").forward(request, response);
            } else if (userPath.equals("/signup")) {
                request.getRequestDispatcher("/WEB-INF/planeview" + userPath + ".jsp").forward(request, response);

            } else if (userPath.equals("/main")) {
                session.setAttribute("sign", "Sign in");
                session.setAttribute("login", "login");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                session.invalidate();

            } else if (userPath.equals("/room")) {
                String city = request.getParameter("city");
                request.setAttribute("city", city);
                searchedApartments = search.searchByCity(apartments, city);

                request.setAttribute("apartaments", searchedApartments);
                request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);

//            } else if (userPath.equals("/user")) {
//                String id = request.getParameter("id");
//
//                request.setAttribute("user", userService.getById(Integer.parseInt(id)));
//                request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);

//            } else if (userPath.equals("/admin")) {
//                String show = request.getParameter("show");
//                if (show.equals("users")) {
//                    request.setAttribute("users", userService.getAllUsers());
//                    //request.setAttribute("users", "users");
//                } else if (show.equals("apartaments")) {
//                    request.setAttribute("apartaments", apartamentService.getAllApartments());
//                } else {
//                    request.setAttribute("reservation_dates", reservationDatesService.getAllReservationDates());
//                }
//                request.getRequestDispatcher("/WEB-INF/view" + userPath + ".jsp").forward(request, response);
            }

        // use RequestDispatcher to forward request internally
//        String url = "/WEB-INF/view" + userPath + ".jsp";
//        request.getRequestDispatcher(url).forward(request, response);
        } catch (IllegalStateException e) {
            request.getRequestDispatcher("/WEB-INF/view/Error.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession(false);


        try {
            if (userPath.equals("/signup")) {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (userService.isRegisterUser(email, password) == false) {
                    User user = new User(name, surname, email, password, "Client");
                    request.setAttribute("name", name);
                    userService.registerUser(user);
                    session.setAttribute("email", email);
                    session.setAttribute("password", password);
                    String signout = "Sign out";
                    session.setAttribute("sign", signout);
                    session.setAttribute("login", "main");
                    request.getRequestDispatcher("/WEB-INF/planeview/thankyoupage.jsp").forward(request, response);
                } else {
                    String uncorrectdata = "User with that email or password is registered! Try again";
                    request.setAttribute("uncorrectdata", uncorrectdata);
                    request.getRequestDispatcher("/WEB-INF/planeview/signup.jsp").forward(request, response);
                }
                // if updateCart action is called
            } else if (userPath.equals("/login")) {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (userService.isRegisterUser(email, password)) {
                    session.setAttribute("email", email);
                    session.setAttribute("password", password);
                    String signout = "Sign out";
                    session.setAttribute("sign", signout);
                    session.setAttribute("login", "main");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    String unregistered = "Incorrect data! Please, try again or register ";
                    request.setAttribute("unregistered", unregistered);
                    request.getRequestDispatcher("/WEB-INF/planeview/login.jsp").forward(request, response);
                }

                // if purchase action is called
            } else if (userPath.equals("/adminpanel")) {
                String email = request.getParameter("admin_email");
                String password = request.getParameter("admin_password");

                if (adminService.isAdmin(email, password)) {
                    session.setAttribute("admin_email", email);
                    session.setAttribute("email", email);
                    session.setAttribute("admin_password", password);
                    session.setAttribute("password", password);
                    String signout = "Sign out";
                    session.setAttribute("sign", signout);
                    session.setAttribute("login", "main");
                    request.setAttribute("users", userService.getAllUsers());
                    request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
                } else {
                    String unregistered = "Incorrect data! Please, try again or register ";
                    request.setAttribute("unregistered", unregistered);
                    request.getRequestDispatcher("/WEB-INF/planeview/login.jsp").forward(request, response);
                }
            }
        } catch (NullPointerException ex) {
            String error = "You've entered uncorrect data! Try again";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/planeview/signup.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
