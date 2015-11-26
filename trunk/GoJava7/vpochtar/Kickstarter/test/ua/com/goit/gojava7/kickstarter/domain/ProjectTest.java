package ua.com.goit.gojava7.kickstarter.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ProjectTest {

	private Project project = new Project("name", "summary", 15L, 30);
	
	@Test
	public void testConstructor() {
		assertThat(project.getName(), is("name"));
		assertThat(project.getSummary(), is("summary"));
		assertThat(project.getGoal(), is(15L));
		assertThat(project.getDaysToGo(), is(30));
	}
	
	@Test
	public void testGetName() {
		assertThat(project.getName(), is("name"));
	}
	
	@Test
	public void testGetSummary() {
		assertThat(project.getSummary(), is("summary"));
	}
	
	@Test
	public void testSetGetInfo() {
		project.setInfo("info");
		assertThat(project.getInfo(), is("info"));
	}
	
	@Test
	public void testSetGetPledged() {
		assertThat(project.getPledged(), is(0L));
		project.setPledged(13L);
		assertThat(project.getPledged(), is(13L));
	}
	
	@Test
	public void testSetGetHistory() {
		//assertThat(project.getHistory(), is(""));
		project.setHistory("history");
		assertThat(project.getHistory(), is("history"));
	}
	
	@Test
	public void testSetGetVideo() {
		//assertThat(project.getVideo(), is(""));
		project.setVideo("video");
		assertThat(project.getVideo(), is("video"));
	}
	
	@Test
	public void testSetGetQuestions() {
		//assertThat(project.getQuestions(), is(""));
		project.setQuestions("q");
		assertThat(project.getQuestions(), is("q"));
	}
}
