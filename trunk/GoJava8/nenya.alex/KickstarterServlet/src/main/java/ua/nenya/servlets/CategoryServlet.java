package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.QuoteDao;
import ua.nenya.project.Category;
import ua.nenya.project.Quote;

public class CategoryServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;

	private CategoryDao categoryDao;
	private QuoteDao quoteDao;

	@Override
	public void init() {
		super.init();
		categoryDao = initilizer.getCategoryDao();
		quoteDao = initilizer.getQuoteDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote(new Random());
		request.setAttribute("quote", quote);
		
		List<Category> categories = categoryDao.getCategories();
		request.setAttribute("categories", categories);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/categories.jsp");
		dispatcher.forward(request, response);
	}
}
