package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/categories")
public class CategoriesServlet extends HttpServlet {

	private QuoteStorage quoteStorage;
	private DaoFactory daoFactory;
	private CategoryStorage categoryStorage;

	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(DataSource.DB);
		daoFactory.open();
		quoteStorage = daoFactory.getQuoteDAO();
		categoryStorage = daoFactory.getCategoryDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Quote quote = quoteStorage.get(1);
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(quote.getText() + "\n" + quote.getAuthor() + "\n\n");
		stringBuilder.append("\nList of categories:\n");

		for (int i = 1; i <= categoryStorage.size(); i++) {
			stringBuilder.append((i) + ": " + categoryStorage.get(i).getName() + "\n");
		}

		resp.getWriter().append(stringBuilder);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
