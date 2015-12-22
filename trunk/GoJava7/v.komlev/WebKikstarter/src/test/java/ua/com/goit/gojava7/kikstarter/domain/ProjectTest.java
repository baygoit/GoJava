package ua.com.goit.gojava7.kikstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.Mockito;

public class ProjectTest {

	@Test
	public void testDomainMockito() {

		Project project = Mockito.mock(Project.class);

		assertThat(project.getCategoryID(), is(0));

	}
}
