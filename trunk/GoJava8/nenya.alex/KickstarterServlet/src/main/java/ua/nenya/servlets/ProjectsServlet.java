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
		String categoryName = request.getParameter("categoryName");
		Category category = new Category();
		category.setName(categoryName);

		List<Project> projects = categoryDao.initProjects(category);

		request.setAttribute("projects", projects);
		request.setAttribute("category", category);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/projects.jsp");
		dispatcher.forward(request, response);

	}

}
