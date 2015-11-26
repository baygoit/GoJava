package ua.com.goit.gojava7.kikstarter;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kikstarter.domain.Project;

public class ProjectTest {

	private Project projectTest;

	@Before
	public void setObjectProjectTest() {
		projectTest = new Project("projectTest1", 20000, 5000, 10);
		projectTest.setProjectName("projectTest1");
		projectTest.setProjectDescription("Super project");
		projectTest.setProjectDetailedDescription("Super project - is good");
		projectTest.setProjectQuestion("Do you want a new project?");
		projectTest.setProjectUrl("https://github.com/");
		projectTest.setProjectNecessaryAmount(2000);
		projectTest.setProjectAmountCollected(500);
		projectTest.setProjectDaysToEnd(10);
	}

	@Test
	public void test() {
		assertThat(projectTest.getProjectName(), is("projectTest1"));
		assertThat(projectTest.getProjectDescription(), is("Super project"));
		assertThat(projectTest.getProjectAmountCollected(), is(5500));
		assertThat(projectTest.getProjectDaysToEnd(), is(10));
		assertThat(projectTest.getProjectDetailedDescription(), is("Super project - is good"));
		assertThat(projectTest.getProjectNecessaryAmount(), is(2000));
		assertThat(projectTest.getProjectQuestion(), is("Do you want a new project?"));
		assertThat(projectTest.getProjectUrl(), is("https://github.com/"));
	}

}
