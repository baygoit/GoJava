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
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {

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
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Categories</title></head><body>");
		stringBuilder.append(quote.getText() + "  (c) " + quote.getAuthor());
		stringBuilder.append("</br>");

		for (Category category : categoryDao.getAll()) {
			stringBuilder.append("<a href=\"category?id=" + category.getId() + "\">" + category.getName() + "</a><br/>");

		}

		stringBuilder.append("</body></html>");
		
		req.setAttribute("quote", quote);
		req.getRequestDispatcher("/jsp/categories.jsp").forward(req, resp);
		//resp.getWriter().append(stringBuilder.toString());
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}

}
