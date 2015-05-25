package go_java_4.vadya_zakusylo.kickstarter.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProject {

	private ProjectInterface project;

	@Before
	public void setUp() {
		project = new Project("name", "shortDescription", 0, 0, 0, "history", "urlVideo");
	}

	@After
	public void tearDown() {
		project = null;
	}

	@Test
	public void testGetShortContent() {
		assertEquals(
				"name\n\tshortDescription\n\tNeed money: 0.0\tCurrent money: 0.0\n\tDays left: 0",
				project.getShortContent());
	}

	@Test
	public void testGetFullContent() {
		assertEquals(
				"name\n\tshortDescription\n\tNeed money: 0.0\tCurrent money: 0.0\n\tDays left: 0"
						+ "\n\tHistory of the project: history\n\tLook video: urlVideo",
				project.getFullContent());
	}

}
