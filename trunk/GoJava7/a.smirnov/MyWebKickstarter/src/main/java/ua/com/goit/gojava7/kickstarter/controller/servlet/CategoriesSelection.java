package ua.com.goit.gojava7.kickstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Quote;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;

@WebServlet("/")
public class CategoriesSelection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CategoriesSelection.class);

	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {
		log.info("Starting spring autowiring...");

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

		log.info("Ended spring autowiring...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");

		Quote quote = quoteDao.getRandomQuote();

		log.info("Random quote : " + quote);

		List<Category> categories = categoryDao.getAll();

		log.info("All categories : " + categories);

		request.setAttribute("categories", categories);
		request.setAttribute("quoteText", quote.getText());
		request.setAttribute("quoteAuthor", quote.getAuthor());
		request.getRequestDispatcher("WEB-INF/views/categories_selection.jsp").forward(request, response);
	}
}
