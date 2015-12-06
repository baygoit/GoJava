package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.domain.Quote;

/**
 * Servlet implementation class KickstarterServlet
 */
@WebServlet("/kickstarter")
public class KickstarterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuoteStorage quoteStorage;
	private DataSource dataSource = DataSource.MEMORY;
	private DaoFactory daoFactory = new DaoFactory(dataSource);


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		quoteStorage = daoFactory.getQuoteStorage();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<html><head><title>"+KickstarterServlet.class.getCanonicalName()+"</title></head><body>");
		Quote quote = quoteStorage.getRandomQuote();
		stringBuilder.append("<br>Quoute:</br>");
		stringBuilder.append("<p>"+quote.getText()+"<br> "+ quote.getAuthor()+"</p>");
		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
		response.getWriter().append("Served quoteStorage: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
