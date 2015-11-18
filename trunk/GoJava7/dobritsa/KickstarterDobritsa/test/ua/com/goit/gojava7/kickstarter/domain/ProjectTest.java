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
	private String time = new java.util.Date().toLocaleString();

	@Before
	public void testSetQ() {
		project = new Project("NameTest", "DescriptionTest", 111111, 22222, 33333, "HistoryTest", "LinkTest");
	}

	@Test
	public void testGetSetQuestions() {
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(time, "question1"));
		project.setQuestions(questions);
		assertThat(project.getQuestions().get(0).getQuestion(), is("question1"));
	}

	@Test
	public void testAddQuestions() {
		assertThat(projectEmpty.getQuestions().size(), is(0));
		projectEmpty.addQuestion(new Question());
		assertThat(projectEmpty.getQuestions().size(), is(1));
	}

	@Test
	public void testGetSetRewardss() {
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward(20, "everything changes"));
		project.setRewards(rewards);
		assertThat(project.getRewards().get(0).getAmount(), is(20));
		assertThat(project.getRewards().get(0).getReward(), is("everything changes"));
	}

	@Test
	public void testGetSetName() {
		projectEmpty.setName("Name of empty project");
		assertThat(project.getName(), is("NameTest"));
		assertThat(projectEmpty.getName(), is("Name of empty project"));
	}

	@Test
	public void testGetSetDescription() {
		projectEmpty.setDescription("Description of empty project");
		assertThat(project.getDescription(), is("DescriptionTest"));
		assertThat(projectEmpty.getDescription(), is("Description of empty project"));
	}

	@Test
	public void testGetSetGoal() {
		projectEmpty.setGoal(300000);
		assertThat(project.getGoal(), is(111111));
		assertThat(projectEmpty.getGoal(), is(300000));
	}

	@Test
	public void testGetSetPledged() {
		projectEmpty.setPledged(100000);
		assertThat(project.getPledged(), is(22222));
		assertThat(projectEmpty.getPledged(), is(100000));
	}

	@Test
	public void testGetSetDaysToGo() {
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
	public void testGetSetLink() {
		projectEmpty.setLink("Link of empty project");
		assertThat(project.getLink(), is("LinkTest"));
		assertThat(projectEmpty.getLink(), is("Link of empty project"));
	}

	@Test
	public void testAddToPledged() {
		assertThat(project.getPledged(), is(22222));
		project.addToPledged(2222);
		assertThat(project.getPledged(), is(24444));
	}

}
