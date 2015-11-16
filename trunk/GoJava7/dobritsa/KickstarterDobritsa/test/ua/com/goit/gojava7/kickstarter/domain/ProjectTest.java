package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class ProjectTest extends Assert {
	private Project project = new Project("NameTest", "DescriptionTest", 111111, 22222, 33333, "HistoryTest", "LinkTest",
			"QuestionsTest");
	private Project projectEmpty = new Project();
	
	@Test
	public void testGetName() {
		projectEmpty.setName("Name of empty project");
		assertThat(project.getName(), is("NameTest"));
		assertThat(projectEmpty.getName(), is("Name of empty project"));
	}

	@Test
	public void testGetDescription() {
		projectEmpty.setDescription("Description of empty project");
		assertThat(project.getDescription(), is("DescriptionTest"));
		assertThat(projectEmpty.getDescription(), is("Description of empty project"));
	}

	@Test
	public void testGetGoal() {
		projectEmpty.setGoal(300000);
		assertThat(project.getGoal(), is(111111));
		assertThat(projectEmpty.getGoal(), is(300000));
	}

	@Test
	public void testGetPledged() {
		projectEmpty.setPledged(100000);
		assertThat(project.getPledged(), is(22222));
		assertThat(projectEmpty.getPledged(), is(100000));
	}

	@Test
	public void testGetDaysToGo() {
		projectEmpty.setDaysToGo(22);
		assertThat(project.getDaysToGo(), is(33333));
		assertThat(projectEmpty.getDaysToGo(), is(22));
	}

	@Test
	public void testGetHistory() {
		projectEmpty.setHistory("History of empty project");
		assertThat(project.getHistory(), is("HistoryTest"));
		assertThat(projectEmpty.getHistory(), is("History of empty project"));
	}

	@Test
	public void testGetLink() {
		projectEmpty.setLink("Link of empty project");
		assertThat(project.getLink(), is("LinkTest"));
		assertThat(projectEmpty.getLink(), is("Link of empty project"));
	}

	@Test
	public void testGetQuestions() {
		projectEmpty.setQuestions("Questions of empty project");
		assertThat(project.getQuestions(), is("QuestionsTest"));
		assertThat(projectEmpty.getQuestions(), is("Questions of empty project"));
	}
	
	@Test
	public void testAddToPledged() {
		project.addToPledged(2222);
		assertThat(project.getPledged(), is(24444));
	}

}
