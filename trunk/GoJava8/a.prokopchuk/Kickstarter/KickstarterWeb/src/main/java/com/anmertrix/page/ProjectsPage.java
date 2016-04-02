package com.anmertrix.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anmertrix.dao.CategoryDao;
import com.anmertrix.domain.Category;
import com.anmertrix.domain.Project;

public class ProjectsPage extends Page {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        CategoryDao categoryDao = page.getCategoryDao();
        String categoryIdStr = request.getParameter("categoryId");
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Category category = categoryDao.getCategory(categoryId);
		List<Project> projects = categoryDao.getProjectsByCategoryId(categoryId);
		
		request.setAttribute("category", category);
        request.setAttribute("projects", projects);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/Projects.jsp");
        dispatcher.forward(request, response);
    }

}
