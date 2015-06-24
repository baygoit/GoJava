package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.comments.CommentService;
import dao.comments.DBcommentServiceImpl;
import dao.comments.DefaultCommentService;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;
import dao.project.Project;
import dao.user.User;

public class CommentFormDao implements iModel {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws KickstarterException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			throw new KickstarterException(
					"comments allowed only for registered user");
		}
		CommentService commentService = null;
		if (connected()) {
			commentService = new DBcommentServiceImpl();
		} else {
			commentService =  DefaultCommentService.getInstance();
		}
		ProjectComment comment = new ProjectComment();
		Project project = (Project) session.getAttribute("detailedProject");
		User user = (User) session.getAttribute("user");
		comment.setProjectID(project.getID());
		comment.setUserID(user.getID());
		comment.setComment(request.getParameter("commentForm"));
		commentService.addComment(comment);
		try {
			response.sendRedirect("DetailedProject");
		} catch (IOException e) {

		}

	}

	boolean connected() {
		boolean connected = false;
		try {
			Connection conn = Pool.getInstance().getConnection();
			conn.close();
			connected = true;
		} catch (KickstarterException | SQLException e) {

		}
		return connected;
	}
}
