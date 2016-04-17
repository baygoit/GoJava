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
import com.anmertrix.dao.ProjectDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class ProjectsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static final String PROJECTS_JSP_PATH = "/WEB-INF/jsp/projects.jsp";
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProjectDao projectDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        Category category = getSelectedCategory(request, response);
        if (category == null) {
        	return;
        }
		
		List<Project> projects = projectDao.getProjectsByCategoryId(category.getId());
		
		request.setAttribute("category", category);
        request.setAttribute("projects", projects);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PROJECTS_JSP_PATH);
        dispatcher.forward(request, response);
    }
	
	public Category getSelectedCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			if (!categoryDao.categoryExists(categoryId)) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
			Category category = categoryDao.getCategory(categoryId);
			return category;
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	
	public void init() throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

}
