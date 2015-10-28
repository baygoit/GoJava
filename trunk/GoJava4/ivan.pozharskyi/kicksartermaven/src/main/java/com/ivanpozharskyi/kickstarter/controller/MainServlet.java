package com.ivanpozharskyi.kickstarter.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.ivanpozharskyi.kickstarter.DAO.CategoriesDAO;
import com.ivanpozharskyi.kickstarter.DAO.ConnectionManager;
import com.ivanpozharskyi.kickstarter.DAO.ProjectsDao;
import com.ivanpozharskyi.kickstarter.entity.Category;
import com.ivanpozharskyi.kickstarter.entity.Project;

public class MainServlet extends HttpServlet {

	@Autowired
	CategoriesDAO categories;
	@Autowired
	ProjectsDao projectsDao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		WebApplicationContext context = ContextLoader
				.getCurrentWebApplicationContext();
		final AutowireCapableBeanFactory beanFactory = context
				.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = getAction(req);
		Connection connection = getConnection(req);

		if (action.startsWith("/categories")) {

			List<Category> categoriesSet = categories.getAll();

			req.setAttribute("categories", categoriesSet);

			req.getRequestDispatcher("/categories.jsp").forward(req, resp);

		} else if (action.startsWith("/projects")) {
			int categoryId = Integer.valueOf(req.getParameter("category"));
			// ProjectsDao projectsDao = new ProjectsDao(connection);

			List<Project> projects = null;
			try {
				projects = projectsDao.getProjectsInCategory(categoryId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

			req.setAttribute("projects", projects);
			req.getRequestDispatcher("/Projects.jsp").forward(req, resp);
		} else if (action.startsWith("/project")) {
			int projectId = Integer.valueOf(req.getParameter("id"));
			// ProjectsDao projectsDao = new ProjectsDao(connection);

			Project project = null;
			try {
				project = projectsDao.getProject(projectId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			req.setAttribute("project", project);
			req.getRequestDispatcher("/Project.jsp").forward(req, resp);
		}

	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),
				requestURI.length());
		return action;
	}

	private Connection getConnection(HttpServletRequest req) {
		Connection result = (Connection) req.getSession().getAttribute(
				"connection");
		if (result == null) {
			result = ConnectionManager.getConnection();
			req.getSession().setAttribute("connection", result);
			return result;
		}
		return result;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(req.getParameterMap().toString());

	}

}
