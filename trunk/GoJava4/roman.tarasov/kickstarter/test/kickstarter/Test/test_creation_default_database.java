package kickstarter.Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import kickstarter.Runner;
import kickstarter.dao.defaultServices.ServiceException;
import kickstarter.dao.interfaces.iDAO;
import kickstarter.entity.Category;
import kickstarter.entity.Project;
import kickstarter.entity.ProjectComment;
import kickstarter.entity.Quote;
import kickstarter.mvc.Controller;
import kickstarter.mvc.interfaces.iController;
import kickstarter.mvc.interfaces.iModel;
import kickstarter.mvc.interfaces.iView;
import kickstarter.ui.iUserInterface;

import org.junit.Ignore;
import org.junit.Test;

public class test_creation_default_database {
	Runner runner;
	public Controller controller;
	public iModel imodel;
	public iView iview;
	public iUserInterface ui;
	iController iC;

	public test_creation_default_database() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);
		controller = runner.kickstarter.controller;
		imodel = runner.kickstarter.getModel();
		iview = runner.kickstarter.getView();
		iC = controller;

	}
	
	@Test
	public void test_update_project() throws SQLException {
		iC.setDatabaseDAO();
		Project project = iC.getDao().getProjectService().getProjectById(20);
		project.setPledged(1111);
		iC.getDao().getProjectService().updateProject(project);
		project = iC.getDao().getProjectService().getProjectById(20);
		assertEquals((Double) project.getPledged(), (Double) (double) 1111);
	}

	
	@Test
	public void test_get_comments() throws SQLException {
		iC.setDatabaseDAO();

		List<ProjectComment> comments = iC.getDao().getCommentService()
				.getCommentsByProjectID(23);
		for (ProjectComment comment : comments) {
			System.out.println("comment : " + comment.getComment());
		}

	}

	
	@Test(expected =ServiceException.class)
	public void test_delete_comment_from_default_dao() throws SQLException, ServiceException {
	
		iC.setDefaultDAO();
		iC.getDao().getCommentService().deleteComment(23, 0);
	}

	@Test
	public void test_add_comment() throws SQLException, ServiceException {
		iC.setDatabaseDAO();
		List<ProjectComment> comments = iC.getDao().getCommentService()
				.getCommentsByProjectID(23);
		for (ProjectComment comment : comments) {
			System.out.println("project id: " + comment.getProjectID()
					+ "comment id: " + comment.getCommentID());
		}
		System.out.println("--------------------------------------");
		ProjectComment newComment = new ProjectComment();
		newComment.setComment("new comment");
		newComment.setUserID(7);
		newComment.setProjectID(23);

		iC.getDao().getCommentService().addComment(newComment);
		comments = iC.getDao().getCommentService().getCommentsByProjectID(23);
		for (ProjectComment comment : comments) {
			System.out.println("project id: " + comment.getProjectID()
					+ "comment id: " + comment.getCommentID());
		}

	}
}
