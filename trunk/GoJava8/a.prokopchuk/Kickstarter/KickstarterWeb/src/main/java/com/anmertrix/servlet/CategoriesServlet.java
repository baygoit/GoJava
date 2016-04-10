package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.QuoteDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Quote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class CategoriesServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected QuoteDao quoteDao;
	@Autowired
	protected CategoryDao categoryDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        Quote quote = quoteDao.getRandomQuote();
        List<Category> categories = categoryDao.getCategories();
        
        request.setAttribute("categories", categories);
        request.setAttribute("quote", quote);
        
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(request, response);
        
    }

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
}
