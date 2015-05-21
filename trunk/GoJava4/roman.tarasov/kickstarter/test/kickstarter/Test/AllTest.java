package kickstarter.Test;

import static org.junit.Assert.*;

import kickstarter.entities.ProjectComments;
import kickstarter.entities.Project;
import kickstarter.entities.Quote;


import org.junit.Test;

public class AllTest {

	//Category category = new Category("category");
	Project project = new Project("project", 5);
	ProjectComments comments = new ProjectComments(23);

	@Test
	public void testAddComment() {
		comments.addComment(1, "one");
		comments.addComment(2, "two");
		int[] array = new int[] { 1, 2, 0, 0, 0, 0, 0, 0, 0, 0 };
		assertArrayEquals(comments.usersID, array);
	}

	@Test
	public void testGetCommentLength() {
		assertEquals(0, comments.getCommentLength());
		comments.addComment(1, "one");
		assertEquals(1, comments.getCommentLength());
	}

	@Test
	public void verify_array_resize() {
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		comments.addComment(1, "one");
		assertEquals(11, comments.getCommentLength());
		int[] array = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
		assertArrayEquals(comments.usersID, array);

	}


	@Test
	public void test_Quote() {
		Quote quote = new Quote();
		quote.setQuote("quote");
		assertEquals("quote", quote.getQuote());
		quote.setQuote("");
		assertEquals("", quote.getQuote());
	}

	@Test
	public void detailed_project_info() {

	}

}
