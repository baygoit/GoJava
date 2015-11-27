package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DaoProvider;
import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

@WebServlet(urlPatterns = "/quote")
public class QuoteServlet extends HttpServlet {

	private QuoteDao quoteDao;
	private DaoProvider daoProvider;

	@Override
	public void init() throws ServletException {
		System.out.println("myproperty" + System.getProperty("myproperty"));

		daoProvider = new DaoProvider(DataSource.MYSQL);
		daoProvider.open();
		quoteDao = daoProvider.getQuoteDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote();
		resp.getWriter().append("<html><head><title>Random quote</title></head><body>" + quote.getText() + "  (c) " + quote.getAuthor() + "</body></html>");
	}

	@Override
	public void destroy() {
		daoProvider.close();
	}

}
