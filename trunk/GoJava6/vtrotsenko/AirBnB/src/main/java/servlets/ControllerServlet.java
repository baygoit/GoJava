package servlets;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by root on 04.11.15.
 */
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");


        session.setAttribute("name", name);
        session.setAttribute("lastname", lastname);
        session.setAttribute("email", email);

        User user = new User(1003, name, password, lastname, email);

        if(userDAO.create(user)) {
            response.sendRedirect("/index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        HttpSession session = request.getSession();

        if (path.equals("/registration")) {
            //TODO:


            //request.setAttribute("name", name);
        }
        System.out.println("SERVLET IS WORKING");

        String url = "/WEB-INF/view" + path + ".jsp";
        System.out.println(url);

        request.getRequestDispatcher(url).forward(request, response);

    }
}
