package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.dao.ProjectDao;
import ua.nenya.domain.Project;

public class ProjectsServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categoryName = request.getParameter("categoryName");
		request.setAttribute("categoryName", categoryName);
		
		if(!getCategoryDao().isCategoryExist(categoryName)){
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		ProjectDao projectDao = getProjectDao();
		List<Project> projects = projectDao.getProjects(categoryName);

		
		request.setAttribute("projects", projects);
		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/projects.jsp");
		dispatcher.forward(request, response);

	}

}
