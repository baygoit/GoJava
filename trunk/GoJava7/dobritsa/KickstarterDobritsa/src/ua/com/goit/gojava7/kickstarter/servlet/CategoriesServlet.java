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

@WebServlet("/categories")
public class CategoriesServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private QuoteStorage quoteStorage;	
	private CategoryStorage categoryStorage;

	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(DataSource.DB);
		daoFactory.open();
		quoteStorage = daoFactory.getQuoteDAO();
		categoryStorage = daoFactory.getCategoryDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteStorage.get(1);
		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Categories</title></head><body>");

		stringBuilder.append(quote.getText() + "  (c) " + quote.getAuthor() + "</br></br>");	
		stringBuilder.append("List of categories:</br>");
	
		for (int i = 1; i <= categoryStorage.size(); i++) {		
			stringBuilder.append("<a href=\"projects?id=" + categoryStorage.get(i).getId() + "\">" + categoryStorage.get(i).getName() + "</a><br/>");			
		}

		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder);
	}	
}
