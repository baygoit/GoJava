package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet("/")
public class CategoriesServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private QuoteDao quoteDao;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(MyDataSource.DB);
		quoteDao = daoFactory.getQuoteDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Quote quote = quoteDao.get(1);

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Categories</title></head><body>");
		stringBuilder.append(quote.getText() + "  (c) " + quote.getAuthor() + "</br></br>");

		for (Category category : categoryDao.getAll()) {
			stringBuilder
					.append("<a href=\"projects?id=" + category.getId() + "\">" + category.getName() + "</a><br/>");
		}

		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder.toString());
	}

}
