package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.CategoryDao;
import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Category;
import ua.nenya.domain.Project;

public class ProjectsServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categoryName = request.getParameter("categoryName");
		
		if(!isCategoryExists(categoryName)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		ProjectDao projectDao = getProjectDao();
		List<Project> projects = projectDao.getProjects(categoryName);
		
		request.setAttribute("projects", projects);
		request.setAttribute("categoryName", categoryName);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/projects.jsp");
		dispatcher.forward(request, response);

	}


	private boolean isCategoryExists(String categoryName) {
		CategoryDao categoryDao = getCategoryDao();
		List<Category> categories = categoryDao.getCategories();
		int i = 0;
		for(Category category: categories){
			if(category.getName().equals(categoryName)){
				i++;
				break;
			}
		}
		return i == 1;
	}

}
