package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QuoteDao quoteDao;
	private DaoProvider daoProvider;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		quoteDao = daoProvider.getQuoteDao();
		categoryDao = daoProvider.getCategoryDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("quote", quoteDao.getRandomQuote());
		req.setAttribute("categories", categoryDao.getAll());
		req.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}

}
