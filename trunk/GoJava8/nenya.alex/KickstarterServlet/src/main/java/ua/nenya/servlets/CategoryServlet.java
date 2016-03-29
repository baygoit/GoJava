package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;

public class CategoryServlet extends CommonServlet{
	private static final long serialVersionUID = 1L;

	private CategoryDao categoryDao;

	@Override
	public void init() {
		super.init();
		categoryDao = initilizer.getCategoryDao();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryDao.initCategories();
		request.setAttribute("categories", categories);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/categories.jsp");
		dispatcher.forward(request, response);
	}
}
