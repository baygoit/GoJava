package beans;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static view.eViews.*;
import view.ViewDispatcher;
import view.ViewStrategy;
import dao.pool.KickstarterException;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;
import dao.project.ProjectService;

public class Projects extends DatabaseConnectionChecker implements iBean {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {

		List<Project> sortedProjects = null;
		ProjectService projectService = null;
		if (connected()) {
			projectService = new DBprojectServiceImpl();
		} else {
			projectService =  DefaultProjectServiceImpl.getInstance();
		}

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
				throw new KickstarterException("illegal number of category");

			}
			categoryID = (Integer) session.getAttribute("category");
		}
		sortedProjects = projectService.sortProjectsByCategoryID(categoryID);

		HttpSession session = request.getSession();
		session.setAttribute("category", categoryID);
		request.setAttribute("sortedProjects", sortedProjects);
		ViewDispatcher view = ViewStrategy.getInstance().selectView(PROJECTS_V);
		view.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	}
}