package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;

import kickstarter.dao.defaultServices.DefaultCommentsService;
import kickstarter.entity.ProjectComment;

import org.junit.Test;

public class test_comments_repository {
	DefaultCommentsService defaultCommentsService;
	ProjectComment projectComment;

	@Test
	public void test() {
		defaultCommentsService=new DefaultCommentsService();
		projectComment.setComment("new");
		defaultCommentsService.addComment(projectComment);
		
	List<ProjectComment> listOfCommentsByProjectID=defaultCommentsService.getCommentsByProjectID(0);
	;
	assertEquals(listOfCommentsByProjectID.get(0).getComment(), "new");
	projectComment= new ProjectComment();
	projectComment.setComment("new2");
	defaultCommentsService.addComment(projectComment);
	assertEquals(listOfCommentsByProjectID.get(1).getComment(), "new2");
	
	}

}
