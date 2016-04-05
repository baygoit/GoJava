package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.domain.Project;

public class ProjectsServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;

	private CategoryDao categoryDao;

	@Override
	public void init() {
		super.init();
		categoryDao = getInitilizer().getCategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");

		List<Project> projects = categoryDao.getProjects(categoryName);

		request.setAttribute("projects", projects);
		request.setAttribute("categoryName", categoryName);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/projects.jsp");
		dispatcher.forward(request, response);

	}

}
