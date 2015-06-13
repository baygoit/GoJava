package edu.kickstarter.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kickstarter.DAO.Dao;
import edu.kickstarter.database.KickstarterException;
import edu.kickstarter.entity.Category;
import edu.kickstarter.entity.Project;
import edu.kickstarter.entity.Quote;
import edu.kickstarter.model.MainModelImpl;
import edu.kickstarter.model.Model;
import edu.kickstarter.model.ProjectsModelImpl;

/**
 * Servlet implementation class Main
 */

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = getAction(request);
		if (action.startsWith("/main")) {
			forwardMain(request, response);
			return;
		}

		if (action.startsWith("/projects")) {
			forwardProjects(request, response);
			return;
		}
		request.getRequestDispatcher("Error.jsp").forward(request, response);
	}

	private void forwardProjects(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Model projectsModel = new ProjectsModelImpl();
		Object attribute;
		try {
			projectsModel.setParameters(Integer.valueOf(request.getParameter("category")));
			attribute = projectsModel.getAttribute("sortedProjects");
			@SuppressWarnings("unchecked")
			List<Project> sortedProjects = (List<Project>) attribute;
			request.setAttribute("sortedProjects", sortedProjects);
			request.getRequestDispatcher("Projects.jsp").forward(request,
					response);
		} catch (KickstarterException e) {
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	private void forwardMain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model mainModel = new MainModelImpl();
		
		try {
			@SuppressWarnings("unchecked")
			List<Category>categories = (List<Category>) mainModel.getAttribute("categories");
			Quote quote = (Quote) mainModel.getAttribute("quote");
			request.setAttribute("categories", categories);
			request.setAttribute("quote", quote);
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		} catch (KickstarterException e) {
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

	@Override
	public void init() throws ServletException {
	}

	@Override
	public void destroy() {
		super.destroy();
		try {
			Dao.getInstance();
			Dao.getDatabaseService().closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),
				requestURI.length());
		return action;
	}
}