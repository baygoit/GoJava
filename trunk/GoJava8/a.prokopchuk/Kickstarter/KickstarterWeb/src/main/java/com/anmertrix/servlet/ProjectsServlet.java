package com.anmertrix.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.dao.NoResultException;
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class ProjectsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	protected CategoryDao categoryDao;
	@Autowired
	protected ProjectDao projectDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Category category = getSelectedCategory(request, response);
        if (category == null) {
        	return;
        }
		
		List<Project> projects = projectDao.getProjectsByCategoryId(category.getId());
		
		request.setAttribute("category", category);
        request.setAttribute("projects", projects);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/projects.jsp");
        dispatcher.forward(request, response);
    }
	
	public Category getSelectedCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String categoryIdStr = request.getParameter("categoryId");
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}

		try {
			return categoryDao.getCategory(categoryId);
		} catch (NoResultException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
