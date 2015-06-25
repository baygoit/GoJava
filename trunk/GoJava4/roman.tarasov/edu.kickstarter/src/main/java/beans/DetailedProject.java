package beans;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.ViewDispatcher;
import view.ViewStrategy;
import view.eViews;
import dao.comments.CommentService;
import dao.comments.DBcommentServiceImpl;
import dao.comments.DefaultCommentService;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.project.DBprojectServiceImpl;
import dao.project.DefaultProjectServiceImpl;
import dao.project.Project;
import dao.project.ProjectService;
import dao.user.DBUserService;
import dao.user.DefaultUserService;
import dao.user.UserService;

public class DetailedProject extends DatabaseConnectionChecker implements iBean {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		ProjectService projectService = null;
		CommentService commentService = null;
		UserService userService = null;
		if (connected()) {
			projectService = new DBprojectServiceImpl();
			commentService = new DBcommentServiceImpl();
			userService = new DBUserService();
		} else {
			projectService = new DefaultProjectServiceImpl();
			commentService = DefaultCommentService.getInstance();
			userService = new DefaultUserService();
		}

		String parameter = request.getParameter("project");
		Integer projectIDfromParam = null;

		try {
			projectIDfromParam = Integer.valueOf(parameter);
		} catch (NumberFormatException e) {

		}

		HttpSession session = request.getSession();
		Project project = (Project) session.getAttribute("detailedProject");
		Integer projectIDfromSession = null;
		if (project != null) {
			projectIDfromSession = project.getID();
		}
		if (projectIDfromParam == null && projectIDfromSession == null) {
			throw new KickstarterException("illegal number of project ");
		}
		if (projectIDfromParam != projectIDfromSession) {
			if (projectIDfromParam != null) {
				project = projectService.getProjectById(projectIDfromParam);
				session.setAttribute("detailedProject", project);

			}
		}

		project = (Project) session.getAttribute("detailedProject");
		List<ProjectComment> comments = null;
		comments = commentService.getCommentsByProjectID(project.getID());
		request.setAttribute("comments", comments);

		List<String> listUsersNames = userService
				.getUsersNamesByListComments(comments);
		request.setAttribute("listUsersNames", listUsersNames);

		ViewDispatcher selectedView = ViewStrategy.getInstance().selectView(
				eViews.DETAILED_PROJECT_V);
		selectedView.forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		// TODO Auto-generated method stub

	}
}
