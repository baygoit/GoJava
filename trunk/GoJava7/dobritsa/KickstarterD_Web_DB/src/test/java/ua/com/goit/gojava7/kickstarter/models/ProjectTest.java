package ua.com.goit.gojava7.kickstarter.models;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.models.Project;

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
		project.setProjectId(11l);
		project.setName("TestName");
		project.setDescription("TestDescription");
		project.setGoal(100l);	
		project.setDaysToGo(3l);
		project.setHistory("TestHistory");
		project.setLink("TestLink");
		//project.setCategoryId(44l);
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testGet() {
		assertThat(project.getProjectId(), is(11l));
		assertThat(project.getName(), is("TestName"));
		assertThat(project.getDescription(), is("TestDescription"));
		assertThat(project.getGoal(), is(100l));	
		assertThat(project.getDaysToGo(), is(3l));
		assertThat(project.getHistory(), is("TestHistory"));
		assertThat(project.getLink(), is("TestLink"));
	//	assertThat(project.getCategoryId(), is(44l));	
	}

}
