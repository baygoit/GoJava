package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
	private String mode = "";
	MyDataSource dataType;

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		ServletContext context = getServletContext();
		mode = context.getInitParameter("mode");
		dataType = MyDataSource.getByStartupKey(mode.toLowerCase());

		System.out.println("-----------------------------");
		System.out.println("CategoriesServlet started   ");
		System.out.println("Kickstarter runs in  " + dataType + " mode (" + mode + ")");
		System.out.println("-----------------------------");

		daoFactory = new DaoFactory(dataType);
		quoteDao = daoFactory.getQuoteDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Quote quote = quoteDao.get(1);

		StringBuilder stringBuilder = new StringBuilder(
				"<html><head><title>Categories</title></head><body bgcolor=\"#fdf5e6\">");
		stringBuilder.append("Kickstarter runs in  " + dataType + " mode (" + mode + ")</br></br>");
		stringBuilder.append(quote.getText() + "  (c) " + quote.getAuthor() + "</br></br>");

		for (Category category : categoryDao.getAll()) {
			stringBuilder
					.append("<a href=\"projects?id=" + category.getId() + "\">" + category.getName() + "</a><br/>");
		}

		stringBuilder.append("</body></html>");
		response.getWriter().append(stringBuilder.toString());
	}

}
