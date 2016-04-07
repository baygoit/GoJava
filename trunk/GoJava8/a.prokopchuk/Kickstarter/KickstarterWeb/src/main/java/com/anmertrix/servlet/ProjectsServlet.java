package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.dao.NoResultException;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class ProjectsServlet extends Servlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String categoryIdStr = request.getParameter("categoryId");
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		Category category = null;
		try {
			category = categoryDao.getCategory(categoryId);
		} catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		List<Project> projects = projectDao.getProjectsByCategoryId(category.getId());
		
		request.setAttribute("category", category);
        request.setAttribute("projects", projects);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/projects.jsp");
        dispatcher.forward(request, response);
    }

}
