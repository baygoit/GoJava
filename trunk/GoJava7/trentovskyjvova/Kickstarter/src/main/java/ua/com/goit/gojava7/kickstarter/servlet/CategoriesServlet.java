package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		DaoProvider daoProvider = (DaoProvider) context.getAttribute(ContextListener.STORAGE_FACTORY);
		
		quoteDao = daoProvider.getQuoteReader();
		categoryDao = daoProvider.getCategoryReader();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote();
		List<Category> categories = categoryDao.getCategories();
		
		req.setAttribute("quote", quote);
		req.setAttribute("categories", categories);
		req.getRequestDispatcher("/WEB-INF/jsp/categories.jsp").forward(req, resp);
	}
	
}
