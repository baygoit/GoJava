package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet("/")
public class CategoriesSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote();

		List<Category> categories = categoryDao.getAll();

		request.setAttribute("categories", categories);
		request.setAttribute("quoteText", quote.getQuoteText());
		request.setAttribute("quoteAuthor", quote.getAuthor());
		request.getRequestDispatcher("WEB-INF/views/categories_selection.jsp").forward(request, response);
	}
}
