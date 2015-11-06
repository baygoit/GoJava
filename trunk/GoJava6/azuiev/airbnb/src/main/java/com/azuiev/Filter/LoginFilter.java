package com.azuiev.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 05.11.15.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ttt");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
