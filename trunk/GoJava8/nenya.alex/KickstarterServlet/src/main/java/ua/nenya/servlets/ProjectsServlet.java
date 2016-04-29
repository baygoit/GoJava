package ua.nenya.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nenya.domain.Project;

public class ProjectsServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String categoryId = request.getParameter("categoryId");
		int id = 0;
		try {
			id = Integer.valueOf(categoryId);
		} catch (NumberFormatException e) {
			request.setAttribute("Id", categoryId);
			request.setAttribute("TestId", -1);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
				
		if(!categoryDao.isCategoryExist(id)){
			request.setAttribute("categoryId", id);
			request.setAttribute("categoryTestId", -1);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		request.setAttribute("categoryId", id);
		List<Project> projects = projectDao.getProjectsByCategoryId(id);
		
		request.setAttribute("projects", projects);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/projects.jsp");
		dispatcher.forward(request, response);

	}

}
