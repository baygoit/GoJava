package ua.com.goit.gojava7.kickstarter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ua.com.goit.gojava7.kickstarter.datasource.contract.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.datasource.contract.QuoteDAO;

public class HeaderInterceptor extends HandlerInterceptorAdapter {

	@Autowired
    private QuoteDAO quoteDAO;
    
    @Autowired
    private CategoryDAO categoryDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		request.setAttribute("quote", quoteDAO.getRandom());
		request.setAttribute("categories", categoryDAO.getAll());
		
		return super.preHandle(request, response, handler);
	}	
	
}
