package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.project.Category;
import ua.nenya.project.Project;

public class ProjectsServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	private CategoryDao categoryDao;

	@Override
	public void init() {
		super.init();
		categoryDao = initilizer.getCategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> categories = categoryDao.getCategories();
		Category category = getCategoryByIndex(request, categories);

		List<Project> projects = categoryDao.initProjects(category);

		request.setAttribute("projects", projects);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/projects.jsp");
		dispatcher.forward(request, response);

	}

	private Category getCategoryByIndex(HttpServletRequest request, List<Category> categories) {
		String categoryIndexStr = request.getParameter("categoryIndex");

		int categoryIndex = 0;
		try {
			categoryIndex = Integer.parseInt(categoryIndexStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		request.setAttribute("categoryIndex", categoryIndex);
		Category category = categories.get(categoryIndex);
		return category;
	}

}
