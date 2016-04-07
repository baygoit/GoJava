package com.anmertrix.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.dao.QuoteDao;

public abstract class Servlet extends HttpServlet {
	
 	private static final long serialVersionUID = 1L;
 	
	@Autowired
	protected QuoteDao quoteDao;
	@Autowired
	protected CategoryDao categoryDao;
	@Autowired
	protected ProjectDao projectDao;
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
