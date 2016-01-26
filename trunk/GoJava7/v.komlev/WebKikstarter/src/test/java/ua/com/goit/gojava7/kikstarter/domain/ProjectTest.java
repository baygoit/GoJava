package ua.com.goit.gojava7.kikstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProjectTest {

	@Test
	public void testDomainMockito() {

		Project project1 = new Project();
		project1.setCategoryID(2);
		project1.setId(1);
		project1.setName("Project1");
		project1.setRequiredSum(3000);
		project1.setCollectedSum(100);
		project1.setEndOfDays(5);
		project1.setGeneralDescription("It is a good project");
		project1.setFullDescription("It is a good project. I hope so.");
		project1.setSumFromUser(200);
		project1.setVideoLink("https://webkikstarter/project1");
		
		assertThat(project1.getId(), is(1));
		assertThat(project1.getCategoryID(), is(2));
		assertThat(project1.getName(), is("Project1"));
		assertThat(project1.getRequiredSum(), is(3000));
		assertThat(project1.getCollectedSum(), is(300));
		assertThat(project1.getEndOfDays(), is(5));
		assertThat(project1.getGenerelDescription(), is("It is a good project"));
		assertThat(project1.getFullDescription(), is("It is a good project. I hope so."));
		assertThat(project1.getVideoLink(), is("https://webkikstarter/project1"));

	}
}
