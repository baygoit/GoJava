package ua.nenya.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;

public class CategoryServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;

	private QuoteDao quoteDao;

	@Override
	public void init() {
		super.init();
		quoteDao = initilizer.getQuoteDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote(new Random());
		request.setAttribute("quote", quote);
		
		request.setAttribute("categories", categories);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp");
		dispatcher.forward(request, response);
	}
}
