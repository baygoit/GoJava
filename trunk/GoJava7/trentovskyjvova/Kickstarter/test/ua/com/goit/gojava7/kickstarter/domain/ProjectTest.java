package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void testGetName() {
		Project progect = new Project("Super project", new Category("s"), 123, 14, 123, "descr", "owner", 100,
				"link");
		assertThat(progect.getName(), is("Super project"));
	}
	
	@Test
	public void testGetCategorie() {
		Category category = new Category("s");
		Project progect = new Project("Super project", category, 123, 14, 123, "descr", "owner", 100,
				"link");
		assertThat(progect.getCategorie(), is(category));
	}
}
