package com.anmertrix.page;

import java.io.IOException;
import java.util.List;

import com.anmertrix.domain.Category;
import com.anmertrix.domain.Quote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoriesPage extends Page {
	
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        Quote quote = quoteDao.getRandomQuote();
        List<Category> categories = categoryDao.getCategories();
        
        request.setAttribute("categories", categories);
        request.setAttribute("quote", quote);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/categories.jsp");
        dispatcher.forward(request, response);
        
    }
	

}
