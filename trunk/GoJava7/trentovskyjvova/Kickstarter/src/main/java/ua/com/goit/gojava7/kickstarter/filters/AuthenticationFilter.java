package ua.com.goit.gojava7.kickstarter.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.goit.gojava7.kickstarter.controller.CategoriesController;
import ua.com.goit.gojava7.kickstarter.domain.User;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {
	private static final Logger log = LoggerFactory.getLogger(CategoriesController.class);
	
	private String LOGIN_ACTION_URI;

	public void init(FilterConfig fConfig) throws ServletException {

		LOGIN_ACTION_URI = fConfig.getInitParameter("loginActionURI");

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		
		log.debug("User: {}", user);
		
		if (user == null && !LOGIN_ACTION_URI.equals(req.getRequestURI())) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			rd.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}

}