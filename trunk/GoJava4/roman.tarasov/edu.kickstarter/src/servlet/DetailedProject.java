package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DetailProjectImpl;
import model.Model;
import model.UserImpl;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.project.Project;

/**
 * Servlet implementation class DetailedProject
 */

public class DetailedProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model projectModel = new DetailProjectImpl();
		Model userModel = new UserImpl();
		
		Object projectFromModel;

		try {
			String parameter = request.getParameter("project");
			Integer projectID = null;
			try {
				projectID = Integer.valueOf(parameter);
			} catch (NumberFormatException e) {

			}
			if (projectID == null) {
				HttpSession session = request.getSession();
				Object objectAttribute = session
						.getAttribute("detailedProject");
				if (objectAttribute == null) {
					throw new KickstarterException("illegal number of project ");
				}
				projectID = (Integer) objectAttribute;
			}
			projectModel.setParameters(projectID);
			projectFromModel = projectModel.getAttribute("detailedProject");
			Project detailedProject = (Project) projectFromModel;

			HttpSession session = request.getSession();
			session.setAttribute("detailedProject", projectID);
			@SuppressWarnings("unchecked")
			List<ProjectComment> comments = (List<ProjectComment>) projectModel
					.getAttribute("comments");
			userModel.setParameters(comments);

			@SuppressWarnings("unchecked")
			List<String> listUsersNames = (List<String>) userModel
				.getAttribute("listUsersNames");

		    request.setAttribute("listUsersNames", listUsersNames);
			request.setAttribute("detailedProject", detailedProject);
			request.setAttribute("comments", comments);

			request.getRequestDispatcher("DetailedProject.jsp").forward(
					request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}
	}

}
