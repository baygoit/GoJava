package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kikstarter.config.DaoProvider;
import ua.com.goit.gojava7.kikstarter.config.MyDataSource;
import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

public class SelectoinCategories extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;
	private DaoProvider daoProvider;

	public void init() throws ServletException {

		daoProvider = new DaoProvider(MyDataSource.ORACLE);
		daoProvider.open();

		quoteDao = daoProvider.getQuoteDao();
		categoryDao = daoProvider.getCategoryDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Quote quote = quoteDao.getRandomQuote();
		List<Category> categories = categoryDao.getAll();

		request.setAttribute("content", quote.getContent());
		request.setAttribute("author", quote.getAuthor());
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/jsp/categories.jsp").forward(request, response);

	}
}
