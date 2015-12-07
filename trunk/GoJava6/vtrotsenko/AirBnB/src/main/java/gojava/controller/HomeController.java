package gojava.controller;

import gojava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

/**
 * Created by root on 04.11.15.
 */
@Controller
public class HomeController {

    /*private UserService userService;

    @Inject
    public HomeController(UserService userService) {
        this.userService = userService;
    }*/

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration() {
        return "registration";
    }

    /*ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String path = request.getServletPath();
        String urlServlet = "/";

        if (path.equals("/registration")) {
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            userService.registerUser(new User(name, password, lastname, email));

            urlServlet = "/login";
        }

        else if (path.equals("/login")) {
            *//*HttpSession httpSession = request.getSession();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userService.login(email, password);
            httpSession.setAttribute("user", user);

            urlServlet = "/";*//*
        }

        System.out.println(urlServlet + "WAS VISITED DOPOST");

        response.sendRedirect(urlServlet);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        HttpSession httpSession = request.getSession();

        if (path.equals("/registration")) {

        }

        else if (path.equals("/")) {
            User user = (User) httpSession.getAttribute("user");
            httpSession.setAttribute("name", "NAME");
        }

        String url = "/WEB-INF/view" + path + ".jsp";
        System.out.println(url + "WAS VISITED DOGET");

        request.getRequestDispatcher(url).forward(request, response);

    }*/
}
