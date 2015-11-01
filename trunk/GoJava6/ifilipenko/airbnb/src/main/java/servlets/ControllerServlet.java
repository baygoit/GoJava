package servlets;

import model.CityList;
import model.GenderType;
import model.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doGetPost(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            doGetPost(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void doGetPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        // ensures that user input is interpreted as 8-bit Unicode (e.g., for Czech characters)
        request.setCharacterEncoding("UTF-8");

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();

        boolean isResource = false;
        if (userPath.startsWith("/css/")) {
            isResource = true;
        }

        if (userPath.equals("/login")) {
            userPath = pageLogin(request, session);
        } else if (userPath.equals("/welcome")) {
            userPath = pageWelcome(request, session);
        } else if (userPath.equals("/index")){
            userPath = pageSingUp(request, session);
        }

        // use RequestDispatcher to forward request internally
        String url = isResource ? userPath : ("/WEB-INF/view" + userPath + ".jsp");

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String pageLogin(HttpServletRequest request, HttpSession session) {
        String userPath = "/login";

        if (request.getParameter("action") == null) {
            //
        } else if (request.getParameter("action").equals("login")) {
            String email = request.getParameter("email");
            User user = new UserService().getUserByEmail(email);

            if (user != null) {
                session.setAttribute("user", user);

                userPath = "/welcome";
            }
        } else if (request.getParameter("action").equals("logout")) {
            if (session != null) {
                session.invalidate();
            }
        }
        return userPath;
    }

    private String pageWelcome(HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "/login";
        } else {
            return "/welcome";
        }
    }

    private String pageSingUp(HttpServletRequest request, HttpSession session) throws ParseException, IOException {
        String userPath = "/index";
        User user = new User();

        if (request.getParameter("action") == null) {
            //
        }else if (request.getParameter("action").equals("signup")) {
            user.setName(request.getParameter("fname"));
            user.setLastName(request.getParameter("lname"));
            user.setGender(GenderType.FEMALE);
            user.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"));
            user.setEmail(request.getParameter("email"));
            user.setCity(CityList.MIAMI);

            new UserService().createUser(user);

            session.setAttribute("user", user);
            return "/welcome";
        }

        return "/index";
    }


    }
