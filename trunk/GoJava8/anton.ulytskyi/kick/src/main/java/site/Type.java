package site;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOProject;
import domain.BaseOfProjects;
import domain.Project;

import java.io.IOException;
import java.util.List;

public class Type extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			DAOProject base = new DAOProject();
			BaseOfProjects kickstarter;

			kickstarter = base.reload();

			String type = req.getQueryString();
			List<Project> projects = kickstarter.selectCategory(type);

			req.setAttribute("type", type);
			req.setAttribute("projects", projects);
			req.getRequestDispatcher("Type.jsp").forward(req, resp);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}