package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDAO;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDAO;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet("/categories")
public class CategoryListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Autowired
    private QuoteDAO quoteDAO;
    
    @Autowired
    private CategoryDAO categoryDAO; 

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
        Random rnd = new Random();       
        List<Quote> quotes = quoteDAO.getAll();     
        
        request.setAttribute("quote", quotes.get(rnd.nextInt(quotes.size())));        
        request.setAttribute("categories", categoryDAO.getAll());
        request.setAttribute("topCategories", categoryDAO.getTopDonated(5));
        request.getRequestDispatcher("view/Categories.jsp").forward(request, response);
    }

    @Override
    public void init() throws ServletException {
    	SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
