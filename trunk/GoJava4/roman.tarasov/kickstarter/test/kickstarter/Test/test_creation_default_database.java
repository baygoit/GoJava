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
	iController i;

	public test_creation_default_database() {
		runner = new Runner();
		ui = new TestUI();
		runner.init();
		runner.kickstarter.testUI(ui);
		controller = runner.kickstarter.controller;
		imodel = runner.kickstarter.getModel();
		iview = runner.kickstarter.getView();
		 i=controller;

	}
//@Ignore
	@Test
	public void test() throws SQLException {
		i.setDatabaseDAO();
		List<Category>list=i.getDao().getCategoryService().getAll();
		Project project =i.getDao().getProjectService().getProjectById(20);
	}
//@Ignore
	@Test
	public void test_update_project() throws SQLException {
		i.setDatabaseDAO();
		List<Category>list=i.getDao().getCategoryService().getAll();
		Project project =i.getDao().getProjectService().getProjectById(20);
		//System.out.println("pledged before update: "+project.getPledged());
		project.setPledged(1111);
		i.getDao().getProjectService().updateProject(project);
		//System.out.println("pledged after update: "+project.getPledged());
		project=i.getDao().getProjectService().getProjectById(20);
		assertEquals((Double)project.getPledged(), (Double)(double)1111);
	}
//@Ignore
	@Test
	public void test_get_comments() throws SQLException {
		i.setDatabaseDAO();
	
		 List<ProjectComment> comments = i.getDao().getCommentService().getCommentsByProjectID(23);
		 for (ProjectComment comment:comments){
			 System.out.println("comment : "+comment.getComment());
		 }
	
	}
	@Test
	public void test_delete_comment() throws SQLException, ServiceException {
		i.setDatabaseDAO();
		 List<ProjectComment> comments = i.getDao().getCommentService().getCommentsByProjectID(23);
		 for (ProjectComment comment:comments){
			 System.out.println("project id: "+comment.getProjectID()+"comment id: "+comment.getCommentID());
		 }
		 System.out.println("--------------------------------------");
		 i.getDao().getCommentService().deleteComment(23, 3);
		// i.getDao().getCommentService().deleteComment(23, 3);
		  comments = i.getDao().getCommentService().getCommentsByProjectID(23);
		 for (ProjectComment comment:comments){
			 System.out.println("project id: "+comment.getProjectID()+"comment id: "+comment.getCommentID());
		 }
	
	}
}
