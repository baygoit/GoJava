package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;

import kickstarter.repository.facade.entity.ProjectComment;
import kickstarter.repository.facade.entityRepositories.CommentsRepository;

import org.junit.Test;

public class test_comments_repository {
	CommentsRepository commentsRepository;
	ProjectComment projectComment;

	@Test
	public void test() {
		commentsRepository=new CommentsRepository();
		projectComment.setComment("new");
		commentsRepository.addComment(projectComment);
		
	List<ProjectComment> listOfCommentsByProjectID=commentsRepository.getCommentsByProjectID(0);
	;
	assertEquals(listOfCommentsByProjectID.get(0).getComment(), "new");
	projectComment= new ProjectComment();
	projectComment.setComment("new2");
	commentsRepository.addComment(projectComment);
	assertEquals(listOfCommentsByProjectID.get(1).getComment(), "new2");
	
	}

}
