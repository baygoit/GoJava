package com.gojava6.airbnb.servlet.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

/**
 * @Autor Andrey Chaykin
 * @Since 10.12.2015
 */
public class LogInFilterServlet implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        boolean isLetterOrDigit = true;
        for (int i = 0; i < login.length(); i++) {
            if (!Character.isLetterOrDigit(login.charAt(i))) {
                isLetterOrDigit = false;
                break;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                isLetterOrDigit = false;
                break;
            }
        }


        if (login != null && !login.isEmpty() && isLetterOrDigit) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html");
            PrintWriter out = res.getWriter();

            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";

            out.println(docType + "<html><head><title>error login</title></head>" +
                    "<body> Sorry, your login cant include special symbols!</body></html>");

            RequestDispatcher rd = req.getRequestDispatcher("index.html");
            rd.include(req, res);

        }


    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
