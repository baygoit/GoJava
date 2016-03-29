package ua.nenya.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Quote;

public class QuoteServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuoteDao quoteDao = initilizer.getQuoteDao();
		Quote quote = quoteDao.getRandomQuote(new Random());
		request.setAttribute("quote", quote);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/quote.jsp");
		dispatcher.forward(request, response);
	}
}
