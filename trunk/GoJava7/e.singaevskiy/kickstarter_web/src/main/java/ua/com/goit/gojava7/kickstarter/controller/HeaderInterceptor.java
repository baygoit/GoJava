package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

	@Autowired
    private QuoteDAO quoteDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("HeaderInterceptor");
		
		Random rnd = new Random();       
		List<Quote> quotes = quoteDAO.getAll();
		request.setAttribute("quote", quotes.get(rnd.nextInt(quotes.size())));
		request.setAttribute("categories", categoryDAO.getAll());
		
		return super.preHandle(request, response, handler);
	}	
	
}
