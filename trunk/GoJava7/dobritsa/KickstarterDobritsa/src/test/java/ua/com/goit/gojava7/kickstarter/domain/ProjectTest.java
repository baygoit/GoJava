package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.io.PrintStream;

@RunWith(MockitoJUnitRunner.class)
public class ProjectTest extends Assert {

	private Project project = new Project();

	@Mock
	private PrintStream printSteam;

	@Before
	public void testSetUp() {
		project.setId(11);
		project.setName("TestName");
		project.setDescription("TestDescription");
		project.setGoal(100);
		project.setPledged(10);
		project.setDaysToGo(3);
		project.setHistory("TestHistory");
		project.setLink("TestLink");
		project.setCategoryId(44);
		project.setCategoryName("TestCategory");
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(project.getId(), is(11));
		assertThat(project.getName(), is("TestName"));
		assertThat(project.getDescription(), is("TestDescription"));
		assertThat(project.getGoal(), is(100));
		assertThat(project.getPledged(), is(10));
		assertThat(project.getDaysToGo(), is(3));
		assertThat(project.getHistory(), is("TestHistory"));
		assertThat(project.getLink(), is("TestLink"));
		assertThat(project.getCategoryId(), is(44));
		assertThat(project.getCategoryName(), is("TestCategory"));
	}

	@Test
	public void testUpdatePledged() {
		assertThat(project.getPledged(), is(10));
		project.updatePledged(2);
		assertThat(project.getPledged(), is(12));
	}

}
