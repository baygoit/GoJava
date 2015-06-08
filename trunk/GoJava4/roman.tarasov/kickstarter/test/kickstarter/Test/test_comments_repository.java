package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;

import kickstarter.dao.defaultServices.DefaultCommentService;
import kickstarter.entity.ProjectComment;

import org.junit.Test;

public class test_comments_repository {
	DefaultCommentService defaultCommentService;
	ProjectComment projectComment;

	@Test
	public void test() {
		defaultCommentService=new DefaultCommentService();
		projectComment.setComment("new");
		defaultCommentService.addComment(projectComment);
		
	List<ProjectComment> listOfCommentsByProjectID=defaultCommentService.getCommentsByProjectID(0);
	;
	assertEquals(listOfCommentsByProjectID.get(0).getComment(), "new");
	projectComment= new ProjectComment();
	projectComment.setComment("new2");
	defaultCommentService.addComment(projectComment);
	assertEquals(listOfCommentsByProjectID.get(1).getComment(), "new2");
	
	}

}
