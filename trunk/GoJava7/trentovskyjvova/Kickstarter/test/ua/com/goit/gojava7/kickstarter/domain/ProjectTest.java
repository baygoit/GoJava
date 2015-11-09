package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {
	private Category category = new Category("s");
	private Project progect = new Project("Super project", category, 123, 14, 123, "descr", "owner", 100, "link");

	@Test
	public void testGetName() {
		assertThat(progect.getName(), is("Super project"));
	}

	@Test
	public void testGetCategorie() {
		assertThat(progect.getCategorie(), is(category));
	}

	@Test
	public void testGetProject() {
		Object[] result = { 0, "Super project", 123, 14, 123 };
		assertThat(progect.getProject(0), is(result));
	}
}
