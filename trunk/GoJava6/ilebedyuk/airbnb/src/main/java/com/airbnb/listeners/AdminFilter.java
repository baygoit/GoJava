package com.airbnb.listeners;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Игорь on 19.11.2015.
 */
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session == null) {
            try {
                req.getRequestDispatcher("/WEB-INF/planeview/adminlogin.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return;
        } else if (session.getAttribute("admin_email") == null && session.getAttribute("admin_password") == null) {
            String messageAdmin = "If you want to see admin info, you must log in!";
            req.setAttribute("messageAdmin", messageAdmin);
            req.getRequestDispatcher("/WEB-INF/planeview/adminlogin.jsp").forward(request, response);
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
