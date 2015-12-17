package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava7.kickstarter.dao.CategoryDbDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDbDao;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProjectDbDao projectDao;
	
	@Autowired
	private CategoryDbDao categoryDao;

	@Override
	public void init() throws ServletException {		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		int categoryId = Integer.parseInt(request.getParameter("id"));	
		
		request.setAttribute("categoryName", categoryDao.get(categoryId));
		request.setAttribute("projects", projectDao.getByCategory(categoryId));
		request.getRequestDispatcher("/WEB-INF/jsp/projects.jsp").forward(request, response);			
	}
}
