package go_java_4.vadya_zakusylo.kickstarter.repository;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProject {

	private ProjectInterface project;
	private CategoryInterface category;

	@Before
	public void setUp() {
		project = new Project("name", "shortDescription", 50, 30, "history", "urlVideo");

	}

	@After
	public void tearDown() {
		project = null;
	}

	@Test
	public void testGetShortContent() {
		assertEquals(
				"name\n\tshortDescription\n\tNeed money: 50.0\tCurrent money: 0.0\n\tDays left: 30",
				project.getShortContent());
	}

	@Test
	public void testGetFullContent() {
		assertEquals(
				"name\n\tshortDescription\n\tNeed money: 50.0\tCurrent money: 0.0\n\tDays left: 30"
						+ "\n\tHistory of the project: history\n\tLook video: urlVideo",
				project.getFullContent());
	}

	@Test
	public void testSetCategory() {
		assertTrue(this.category == null);
		CategoryInterface categoryFirst = new Category("categoryFirst");
		project.setCategory(categoryFirst);
	}

}
