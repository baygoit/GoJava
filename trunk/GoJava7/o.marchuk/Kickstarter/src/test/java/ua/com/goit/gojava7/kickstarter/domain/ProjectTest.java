package ua.com.goit.gojava7.kickstarter.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ProjectTest {

	private Project project = new Project();

	@Test
	public void testConstructor() {
		assertThat(project.getName(), is("project name"));
		assertThat(project.getShortDescription(), is("short description"));
		assertThat(project.getRequiredAmount(), is(123L));
		assertThat(project.getDaysLeft(), is(5));
		assertThat(project.getGatheredAmount(), is(0L));
	}

	@Test
	public void testSetGetGatheredAmount() {
		assertThat(project.getGatheredAmount(), is(0L));
		project.setGatheredAmount(555L);
		assertThat(project.getGatheredAmount(), is(555L));
	}

	@Test
	public void testSetGetHistory() {
		assertThat(project.getHistory(), is(""));
		project.setHistory("History");
		assertThat(project.getHistory(), is("History"));
	}

	@Test
	public void testSetGetVideoUrl() {
		assertThat(project.getVideoUrl(), is(""));
		project.setVideoUrl("Url");
		assertThat(project.getVideoUrl(), is("Url"));
	}

	@Test
	public void testSetGetQuestionsAndAnswers() {
		assertThat(project.getQuestionsAndAnswers(), is(""));
		project.setQuestionsAndAnswers("Q&As");
		assertThat(project.getQuestionsAndAnswers(), is("Q&As"));
	}


	@Test
	public void testHashCode() {
		assertThat(project.hashCode(), is(881207121));
	}

	@Test
	public void testEquals() {
		Project sameNameProject = new Project();
		Project otherProject = new Project();

		assertThat(project.equals(null), is(false));
		assertThat(project.equals(project), is(true));
		assertThat(project.equals(sameNameProject), is(true));
		assertThat(project.equals(otherProject), is(false));
	}
}
