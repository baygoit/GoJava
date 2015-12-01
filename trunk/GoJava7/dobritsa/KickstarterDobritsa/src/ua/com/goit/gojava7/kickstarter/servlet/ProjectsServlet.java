package ua.com.goit.gojava7.kickstarter.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava7.kickstarter.config.DataSource;
import ua.com.goit.gojava7.kickstarter.dao.DaoFactory;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@WebServlet("/projects")
public class ProjectsServlet extends HttpServlet {

	private DaoFactory daoFactory;
	private ProjectDao projectStorage;

	@Override
	public void init() throws ServletException {
		daoFactory = new DaoFactory(DataSource.DB);
		daoFactory.open();
		projectStorage = daoFactory.getProjectDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));

		StringBuilder stringBuilder = new StringBuilder("<html><head><title>Projects</title></head><body>");
		stringBuilder.append("List of projects:</br>");

		List<Project> projects = new ArrayList<>();
		projects = projectStorage.getByCategory(categoryId);

		for (int i = 0; i < projects.size(); i++) {
			stringBuilder.append("<a href=\"project?id=" + projects.get(i).getId() + "\">" + projects.get(i).getName()
					+ "</a><br/>");
		}

		response.getWriter().append(stringBuilder);
	}
}
