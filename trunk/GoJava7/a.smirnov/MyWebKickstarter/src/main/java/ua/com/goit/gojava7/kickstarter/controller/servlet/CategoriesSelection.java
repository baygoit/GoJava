package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet("/")
public class CategoriesSelection extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;
	private DaoProvider daoProvider;
       
	public void init() throws ServletException {
		
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		
		quoteDao = daoProvider.getQuoteDao();
		categoryDao = daoProvider.getCategoryDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Quote quote = quoteDao.getRandomQuote();
	
		List<Category> categories = categoryDao.getAll();
	
		HttpSession session = request.getSession();
		session.setAttribute("categories", categories);
		session.setAttribute("quoteText", quote.getQuoteText());
		session.setAttribute("quoteAuthor", quote.getAuthor());
		
		request.getRequestDispatcher("WEB-INF/views/categories_selection.jsp").forward(request, response);		
	}
}
