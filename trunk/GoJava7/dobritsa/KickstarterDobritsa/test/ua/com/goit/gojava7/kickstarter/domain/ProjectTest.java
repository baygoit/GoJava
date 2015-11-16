package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest extends Assert {

	private Project projectEmpty = new Project();
	private Project project;
	
	@Before
	public void test() {
		List<String> questions = new ArrayList<String>();
		questions.add("QuestionsTest");
	project = new Project("NameTest", "DescriptionTest", 111111, 22222, 33333, "HistoryTest",
				"LinkTest", questions);
		
	}

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
		projectEmpty.addQuestion("Questions of empty project");
		assertThat(project.getQuestions().get(0), is("QuestionsTest"));
		assertThat(projectEmpty.getQuestions().get(0), is("Questions of empty project"));
	}

	@Test
	public void testAddToPledged() {
		project.addToPledged(2222);
		assertThat(project.getPledged(), is(24444));
	}

}
