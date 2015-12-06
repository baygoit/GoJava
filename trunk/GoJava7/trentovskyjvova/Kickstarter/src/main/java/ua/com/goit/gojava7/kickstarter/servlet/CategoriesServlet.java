package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSourceTypes;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {
	private DaoProvider daoProvider;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		daoProvider = new DaoProvider(DataSourceTypes.POSTGRES);
		daoProvider.init();
		quoteDao = daoProvider.getQuoteReader();
		categoryDao = daoProvider.getCategoryReader();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote();

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Categories</title></head><body>");
		stringBuilder.append(quote.getText()).append("  (c) ").append(quote.getAuthor());
		stringBuilder.append("</br>");

		for (Category category : categoryDao.getCategories()) {
			stringBuilder.append("<a href=\"projects?id=").append(category.getId()).append("\">")
					.append(category.getName()).append("</a><br/>");

		}
		stringBuilder.append("</body></html>");
		
		resp.getWriter().append(stringBuilder.toString());
	}
	
}
