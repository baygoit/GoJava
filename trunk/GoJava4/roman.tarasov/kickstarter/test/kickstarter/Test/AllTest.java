package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.entities.Category;
import kickstarter.entities.Comments;
import kickstarter.entities.Project;
import kickstarter.entities.Quote;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;

import org.junit.Test;

public class AllTest {

	Category category = new Category("category");
	Project project = new Project("project", category);
	Comments comments = new Comments(project);

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
	public void verify_names_of_added_categories() {
		Storage<Category> categories = new EntityStorage<Category>();
		// when
		categories.add(new Category("name1"));
		categories.add(new Category("name2"));
		categories.add(new Category("name3"));
		categories.add(new Category("name4"));
		categories.add(new Category("name5"));
		categories.add(new Category("name6"));
		categories.add(new Category("name7"));
		categories.add(new Category("name8"));
		categories.add(new Category("name9"));
		categories.add(new Category("name10"));
		categories.add(new Category("name11"));
		categories.add(new Category("name12"));

		// then
		assertEquals("name1", categories.getEntity(0).name);
		assertEquals("name2", categories.getEntity(1).name);
		assertEquals("name3", categories.getEntity(2).name);
		assertEquals("name4", categories.getEntity(3).name);
		assertEquals("name5", categories.getEntity(4).name);
		assertEquals("name6", categories.getEntity(5).name);
		assertEquals("name7", categories.getEntity(6).name);
		assertEquals("name8", categories.getEntity(7).name);
		assertEquals("name9", categories.getEntity(8).name);
		assertEquals("name10", categories.getEntity(9).name);
		assertEquals("name11", categories.getEntity(10).name);
		assertEquals("name12", categories.getEntity(11).name);
	}

	@Test
	public void verify_null_values() {
		Storage<Category> categories = new EntityStorage<Category>();

		assertNull(categories.getEntity(0));
		assertNull(categories.getEntity(1));
		assertEquals(categories.length(), 0);
	}

	@Test
	public void get_random_object_from_objects() {
		Storage<Quote> quotes = new EntityStorage<Quote>();
		quotes.add(new Quote());
		assertNotNull(quotes.getRandom());
	}

	@Test
	public void should_null_result_for_random_object_from_null_storage() {
		Storage<Quote> quotes = new EntityStorage<Quote>();
		assertNull(quotes.getRandom());
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
