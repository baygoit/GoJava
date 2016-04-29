package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.domain.Category;
import ua.nenya.domain.Quote;

public class CategoryServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Quote quote = quoteDao.getRandomQuote();
		request.setAttribute("quote", quote);
		List<Category> categories = categoryDao.getCategories();
		request.setAttribute("categories", categories);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/categories.jsp");
		dispatcher.forward(request, response);
	}
}
