package com.gojava6.airbnb.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Autor Andrey Chaykin
 * @Since 11.12.2015
 */
public class AuthenticationFilter implements Filter {

    ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        context = filterConfig.getServletContext();
        context.log("Authentication initialized!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if(session == null && !(url.endsWith("index.html") || url.endsWith("login") || !url.isEmpty())) {
            context.log("Unauthorized access request");
//            response.sendRedirect("index.html");
//            response.sendRedirect("index.html");
            response.sendError(403, "Sorry, you don't have necessary permissions for the resource!<br>" +
                    "Please login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
