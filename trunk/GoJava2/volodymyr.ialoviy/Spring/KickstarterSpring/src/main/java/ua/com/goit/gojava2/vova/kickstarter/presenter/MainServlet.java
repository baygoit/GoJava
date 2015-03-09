package ua.com.goit.gojava2.vova.kickstarter.presenter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import ua.com.goit.gojava2.vova.kickstarter.model.Categories;
import ua.com.goit.gojava2.vova.kickstarter.model.Category;
import ua.com.goit.gojava2.vova.kickstarter.model.Project;
import ua.com.goit.gojava2.vova.kickstarter.model.Projects;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Autowired
	private Categories categoriesDAO;
	
	@Autowired
	private Projects projectsDAO;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String action = getAction(req);

		if (action.startsWith("/categories")) {

			List<Category> categories = categoriesDAO.getCategories();

			req.setAttribute("categories", categories);
			req.getRequestDispatcher("categories.jsp").forward(req, resp);
		} else if (action.startsWith("/projects")) {
			int categoryID = Integer.valueOf(req.getParameter("category"));

			List<Project> projects = projectsDAO.getProgectsForCategory(categoryID);

			req.setAttribute("projects", projects);
			req.getRequestDispatcher("projects.jsp").forward(req, resp);
		} else if (action.startsWith("/project")) {
			int projectID = Integer.valueOf(req.getParameter("project"));

			Project project = projectsDAO.getProgect(projectID);

			req.setAttribute("project", project);
			req.getRequestDispatcher("project.jsp").forward(req, resp);
		}

	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),
				requestURI.length());
		return action;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());
	}

}
