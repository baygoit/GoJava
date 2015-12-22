package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kikstarter.domain.Category;
import ua.com.goit.gojava7.kikstarter.domain.Quote;

@WebServlet("/categories")
public class SelectoinCategories extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private QuoteDao quoteDao;

	@Autowired
	private CategoryDao categoryDao;

	public void init() throws ServletException {

		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, getServletContext());

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Quote quote = quoteDao.getRandomQuote();
		List<Category> categories = categoryDao.getAll();

		request.setAttribute("content", quote.getContent());
		request.setAttribute("author", quote.getAuthor());
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("WEB-INF/jsp/categories.jsp").forward(request, response);

	}
}
