package ua.com.goit.gojava7.kikstarter.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kikstarter.config.DaoProvider;
import ua.com.goit.gojava7.kikstarter.config.MyDataSource;
import ua.com.goit.gojava7.kikstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kikstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kikstarter.domain.Project;

public class SelectionProjects extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProjectDao projectDao;
	private CategoryDao categoryDao;
	private DaoProvider daoProvider;

	public void init() throws ServletException {
		
		daoProvider=new DaoProvider(MyDataSource.ORACLE);
		daoProvider.open();
		
		projectDao = daoProvider.getProjectDao();
		categoryDao=daoProvider.getCategoryDao();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		List<Project> selectedProjects = projectDao.getProjectsFromCategory(categoryId);
		
		request.setAttribute("category", categoryDao.getCategory(categoryId));
		request.setAttribute("projects", selectedProjects);
		request.getRequestDispatcher("WEB-INF/jsp/projects.jsp").forward(request, response);
		
	}
}
