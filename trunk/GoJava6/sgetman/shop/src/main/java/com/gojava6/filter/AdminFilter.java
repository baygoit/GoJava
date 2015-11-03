/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 10/30/15
 */
@WebFilter(urlPatterns = "admin/admin.jsp")
public class AdminFilter implements Filter {


    private static final Logger logger = LogManager.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // if session doesn't exist, forward user to welcome page
        if (req.getSession() == null
                || !isCredsValid(req)) {
            try {
                req.getRequestDispatcher("/admin/login.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isCredsValid(HttpServletRequest request) {
        HttpSession session = request.getSession();


        String user = (String) session.getAttribute("user");
        String pass = (String) session.getAttribute("pass");

        ServletContext servletContext =
                request.getServletContext();

        if(user == null || pass == null) {
            logger.info("you are not logged in");
            return false;
        }
        else if (!user.equals(servletContext.getInitParameter("user"))
                 || !user.equals(servletContext.getInitParameter("pass"))) {
            logger.error("invalid user or password, user: " + user + " , pass: " + pass);
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
