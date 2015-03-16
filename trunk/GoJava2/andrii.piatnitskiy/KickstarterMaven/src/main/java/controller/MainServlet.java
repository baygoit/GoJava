package controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;



import model.CategoriesDAO;
import model.Category;
import model.Project;
import model.ProjectsDAO;

@Controller
public class MainServlet extends HttpServlet {
	 @Autowired
	 CategoriesDAO categoriesDAO;
	 @Autowired
	 ProjectsDAO projectsDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
		
	}
	
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

//		WebApplicationContext springContext = WebApplicationContextUtils
//				.getWebApplicationContext(getServletContext());
//
//		CategoriesDAO categoriesDAO = (CategoriesDAO) springContext
//				.getBean("categoriesDAO");

		String action = getAction(request);
		// TODO refactoring to polymorph with map
		if (action.startsWith("/categories")) {
			LinkedList<Category> categories = categoriesDAO.getCategoriesList();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/categories.jsp").forward(request,
					response);
		}
		 else if (action.startsWith("/projects")) {
		 int categoryId = Integer.valueOf(request.getParameter("category"));
		 LinkedList<Project> projects = projectsDAO
		 .getProjectsList(categoryId);
		 request.setAttribute("projects", projects);
		 request.getRequestDispatcher("/projects.jsp").forward(request,
		 response);
		 }

	}

	private String getAction(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length(),
				requestURI.length());
		return action;
	}
}
