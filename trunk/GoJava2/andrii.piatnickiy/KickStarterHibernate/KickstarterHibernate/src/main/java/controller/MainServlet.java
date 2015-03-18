package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		String action = getAction(request);
		// TODO refactoring to polymorph with map
		if (action.startsWith("/categories")) {

			LinkedList<Category> categories = categoriesDAO.getCategoriesList();

			for (Category category : categories) {
				printWriter.print("<p>");
				printWriter
						.print("<a href=\"/KickstarterHibernate-0.0.1-SNAPSHOT/projects?category=");
				printWriter.print(category.getId());
				printWriter.print("\">");
				printWriter.print(category.getName());
				printWriter.print("</a>");
				printWriter.print("</p>");
			}

			// request.setAttribute("categories", categories);
			// request.getRequestDispatcher("/categories.jsp").forward(request,
			// response);
		} else if (action.startsWith("/projects")) {
			int categoryId = Integer.valueOf(request.getParameter("category"));
			LinkedList<Project> projects = projectsDAO
					.getProjectsList(categoryId);

			for (Project project : projects) {
				printWriter.print("<p>");
				printWriter.print(project.getName());
				printWriter.print("</p>");
			}

			// request.setAttribute("projects", projects);
			// request.getRequestDispatcher("/projects.jsp").forward(request,
			// response);
		}

	}

	private String getAction(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String action = requestURI.substring(request.getContextPath().length(),
				requestURI.length());
		return action;
	}
}
