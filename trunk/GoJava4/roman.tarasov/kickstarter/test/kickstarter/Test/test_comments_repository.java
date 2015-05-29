package kickstarter.Test;

import static org.junit.Assert.*;

import java.util.List;

import kickstarter.entities.ProjectComments;
import kickstarter.repository.facade.CommentsRepository;

import org.junit.Test;

public class test_comments_repository {
	CommentsRepository commentsRepository;
	ProjectComments projectComments;

	@Test
	public void test() {
		commentsRepository=new CommentsRepository();
		projectComments= new ProjectComments(0, 0, "new");
		commentsRepository.addComment(projectComments);
		
	List<ProjectComments> listOfCommentsByProjectID=commentsRepository.getCommentsByProjectID(0);
	;
	assertEquals(listOfCommentsByProjectID.get(0).getComment(), "new");
	projectComments= new ProjectComments(0, 0, "new2");
	commentsRepository.addComment(projectComments);
	assertEquals(listOfCommentsByProjectID.get(1).getComment(), "new2");
	
	}

}
