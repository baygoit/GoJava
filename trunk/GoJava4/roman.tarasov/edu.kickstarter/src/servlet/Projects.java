package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Model;
import model.ProjectsImpl;
import dao.pool.KickstarterException;
import dao.project.Project;

/**
 * Servlet implementation class Projects
 */

public class Projects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model projectsModel = new ProjectsImpl();

		Object attribute;
		Integer categoryID = null;
		String parameterFromURL = request.getParameter("category");
		try {
			categoryID = Integer.valueOf(parameterFromURL);
		} catch (NumberFormatException e) {

		}
		if (categoryID == null) {
			HttpSession session = request.getSession();
			Object objectAttribute = session.getAttribute("category");
			if (objectAttribute == null) {
				request.getRequestDispatcher("Main").forward(request, response);
				return;
			}
			categoryID = (Integer) session.getAttribute("category");
		}
		try {
			projectsModel.setParameters(categoryID);
			attribute = projectsModel.getAttribute("sortedProjects");
			@SuppressWarnings("unchecked")
			List<Project> sortedProjects = (List<Project>) attribute;
			HttpSession session = request.getSession();
			session.setAttribute("category", categoryID);

			request.setAttribute("sortedProjects", sortedProjects);
			request.getRequestDispatcher("Projects.jsp").forward(request,
					response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}
}
