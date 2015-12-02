package main.ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.ua.com.goit.gojava7.kickstarter.beans.Category;
import main.ua.com.goit.gojava7.kickstarter.beans.Quote;
import main.ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import main.ua.com.goit.gojava7.kickstarter.config.DataSource;
import main.ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import main.ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
	private static final String SEPARATOR = "*********************************************************";
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
		Quote quote = quoteDao.getRandomQuote();
		StringBuilder result = new StringBuilder().
			append("<html>").
				append("<head>").
					append("<title>Categories</title>").
				append("</head>").
				append("<body>").
					append("<br>").append(quote.getQuoteText()).append(" (c) ").append(quote.getAuthor()).append("</br>").
					append(SEPARATOR).
					append("<br>").append("Please select category : ").append("</br>").
					append("<ol>");

		for(Category category : categoryDao.getAll()) {
			result.
				append("<li>").
					append("<a href=\"category?id=").append(category.getUniqueID()).append("\">").append(category.getName()).append("</a>").
				append("</li>");
		}
			
		result.
					append("</ol>").
					append(SEPARATOR).
				append("</body>").
			append("</html>");
		resp.getWriter().append(result);
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}
}
