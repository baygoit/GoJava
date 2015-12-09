package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.MyDataSource;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private ProjectDao projectDao;
	private CategoryDao categoryDao;

	@Override
	public void init() throws ServletException {
		
		MyDataSource dataType = (MyDataSource) getServletContext().getAttribute("mode");				
		
		daoFactory = new DaoFactory(dataType);
		projectDao = daoFactory.getProjectDAO();
		categoryDao = daoFactory.getCategoryDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int categoryId = Integer.parseInt(request.getParameter("id"));		

		request.setAttribute("projects", projectDao.getByCategory(categoryId));
		request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);			
	}
}
