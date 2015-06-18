package tests;

import static org.junit.Assert.*;
import java.util.List;
import model.Model;
import model.UserImpl;
import org.junit.Test;
import dao.comments.CommentService;
import dao.comments.DBcommentServiceImpl;
import dao.comments.DefaultCommentServiceImpl;
import dao.comments.ProjectComment;
import dao.pool.KickstarterException;
import dao.pool.Pool;

public class test_userImpl {

	@SuppressWarnings("unchecked")
	@Test
	public void test_listUsersNames_for_DefaultCommentService() {

		Model userModel = new UserImpl();
		CommentService commService = new DefaultCommentServiceImpl();
		List<ProjectComment> comments = null;
		try {
			comments = commService.getCommentsByProjectID(20);
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userModel.setParameters(comments);
		List<String> usersNames = null;
		try {

			usersNames = (List<String>) userModel
					.getAttribute("listUsersNames");
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(usersNames.get(1), "mike");
		assertEquals(comments.size(), usersNames.size());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test_listUsersNames_for_DBCommentService() {

		Model userModel = new UserImpl();
		Pool.getInstance().setRealPool(false);
		CommentService commService = new DBcommentServiceImpl();
		List<ProjectComment> comments = null;
		try {
			comments = commService.getCommentsByProjectID(20);
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userModel.setParameters(comments);
		assertNotEquals(comments.size(), 0);
		// System.out.println(comments.get(0).getComment());
		List<String> usersNames = null;
		try {

			usersNames = (List<String>) userModel
					.getAttribute("listUsersNames");
		} catch (KickstarterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(usersNames.get(1), "mike");
		assertEquals(comments.size(), usersNames.size());

	}
}
