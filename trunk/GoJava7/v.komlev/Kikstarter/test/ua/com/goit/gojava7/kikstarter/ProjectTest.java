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
		projectTest.setName("projectTest1");
		projectTest.setDescription("Super project");
		projectTest.setDetailedDescription("Super project - is good");
		projectTest.setQuestion("Do you want a new project?");
		projectTest.setUrl("https://github.com/");
		projectTest.setNecessaryAmount(2000);
		projectTest.setAmountCollected(500);
		projectTest.setProjectDaysToEnd(10);
	}

	@Test
	public void test() {
		assertThat(projectTest.getName(), is("projectTest1"));
		assertThat(projectTest.getDescription(), is("Super project"));
		assertThat(projectTest.getAmountCollected(), is(5500));
		assertThat(projectTest.getEndOfDays(), is(10));
		assertThat(projectTest.getDetailedDescription(), is("Super project - is good"));
		assertThat(projectTest.getNecessaryAmount(), is(2000));
		assertThat(projectTest.getProjectQuestion(), is("Do you want a new project?"));
		assertThat(projectTest.getUrl(), is("https://github.com/"));
	}

}
