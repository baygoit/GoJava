package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DetailProjectImpl;
import model.MainImpl;
import model.Model;
import model.ProjectsImpl;
import dao.category.Category;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.project.Project;
import dao.quote.Quote;

/**
 * Servlet implementation class Main
 */

public class Main extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = getAction(request);
		if (action.startsWith("/main") || action.equals("/")) {
			forwardMain(request, response);
			return;
		}

		if (action.startsWith("/projects")) {
			request.setAttribute("previous", "main");
			forwardProjects(request, response);
			return;
		}
		if (action.startsWith("/detailedProject")) {
			request.setAttribute("previous", "projects");
			forwardDetailedProject(request, response);
			return;
		}
		KickstarterException e = new KickstarterException("incorrect URL");
		request.setAttribute("error", e);
		request.getRequestDispatcher("Error.jsp").forward(request, response);
	}

	private void forwardDetailedProject(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model detailProject = new DetailProjectImpl();
		Object projectFromModel;

		try {
			String parameter = request.getParameter("project");
			Integer projectID = 0;
			try {
				projectID = Integer.valueOf(parameter);
			} catch (NumberFormatException e) {
				throw new KickstarterException("illegal number of project ", e);
			}
			detailProject.setParameters(projectID);
			projectFromModel = detailProject.getAttribute("detailedProject");
			Project detailedProject = (Project) projectFromModel;
			@SuppressWarnings("unchecked")
			List<ProjectComment> comments = (List<ProjectComment>) detailProject
					.getAttribute("comments");

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

	private void forwardProjects(HttpServletRequest request,
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
				forwardMain(request, response);
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

	private void forwardMain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Model mainModel = new MainImpl();

		try {
			@SuppressWarnings("unchecked")
			List<Category> categories = (List<Category>) mainModel
					.getAttribute("categories");
			Quote quote = (Quote) mainModel.getAttribute("quote");
			request.setAttribute("categories", categories);
			request.setAttribute("quote", quote);
			request.getRequestDispatcher("Main.jsp").forward(request, response);
		} catch (KickstarterException e) {
			request.setAttribute("error", e);
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
			Pool.getInstance().getConnection().close();
		} catch (SQLException | KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAction(HttpServletRequest req) {
		String requestURI = req.getRequestURI();
		String action = requestURI.substring(req.getContextPath().length(),
				requestURI.length());
		return action;
	}
}