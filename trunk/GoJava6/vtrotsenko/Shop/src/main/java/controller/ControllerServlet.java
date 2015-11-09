package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 27.10.15.
 */
@WebServlet(name="ControllerServlet", loadOnStartup = 1, urlPatterns={ "/category",
                                                        "/addToCart",
                                                        "/viewCart",
                                                        "/updateCart",
                                                        "/checkout",
                                                        "/purchase",
                                                        "/chooseLanguage",
                                                        "/registration"})
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if the category page is requested
        if (userPath.equals("/category")) {
            //TODO: Implement category request
        }

        else if (userPath.equals("/registration")) {
            //
        }

        // if cart page is requested
        else if (userPath.equals("/viewCart")) {
            //TODO: Implement cart page request

            userPath = "/cart";
        }

        // if checkout page is requested
        else if (userPath.equals("/checkout")) {
            //TODO: Implement checkout page request
        }

        // if user switches language
        else if (userPath.equals("/chooseLanguage")) {
            //TODO: Implement language request
        }

        // testDATASOURCE
        else if (userPath.equals("/table")) {
            userPath = "/table";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if addToCart action is called
        if (userPath.equals("/addToCart")) {
            //TODO: Implement add product to cart action
        }

        // if updateCart action is called
        else if (userPath.equals("/updateCart")) {
            //TODO: Implement update cart action
        }

        // if purchase action is called
        else if (userPath.equals("/purchase")) {
            //TODO: Implement purchase action

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}