package com.airbnb.listeners;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Игорь on 10.11.2015.
 */
public class SessionTimeoutFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession(false);

        // if session doesn't exist, forward user to welcome page
        if (session == null) {
            try {
                req.getRequestDispatcher("/WEB-INF/planeview/login.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        } else if (session.getAttribute("email") == null && session.getAttribute("password") == null) {
            String messageAboutRegister = "If you want to see information about hosts, you must log in!";
            req.setAttribute("messageAboutRegister", messageAboutRegister);
            req.getRequestDispatcher("/WEB-INF/planeview/login.jsp").forward(request, response);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
