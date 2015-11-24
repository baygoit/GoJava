package ua.com.goit.gojava7.kickstarter.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

public class ProjectTest extends Assert {

	
	private Project project;
	private String time = new java.util.Date().toString();

	@Before
	public void testSetUp() {	
		project = new Project("NameTest", "DescriptionTest", 111111, 22222, 33333);
	}
	
	@Test
	public void tectCreateFullProject() {
		project = new Project("NameTest", "DescriptionTest", 111111, 22222, 33333, "HistoryTest", "NoLink");
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
		assertThat(project.getQuestions().size(), is(0));
		project.addQuestion(new Question("Question"));
		assertThat(project.getQuestions().size(), is(1));
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
	public void testGetName() {
		assertThat(project.getName(), is("NameTest"));		
	}

	@Test
	public void testGetDescription() {		
		assertThat(project.getDescription(), is("DescriptionTest"));		
	}

	@Test
	public void testGetGoal() {	
		assertThat(project.getGoal(), is(111111));		
	}

	@Test
	public void testGetPledged() {	
		assertThat(project.getPledged(), is(22222));		
	}

	@Test
	public void testGetDaysToGo() {		
		assertThat(project.getDaysToGo(), is(33333));		
	}

	@Test
	public void testGetHistory() {
		project.setHistory("History of empty project");	
		assertThat(project.getHistory(), is("History of empty project"));
	}

	@Test
	public void testGetSetLink() {
		project.setLink("Link of empty project");	
		assertThat(project.getLink(), is("Link of empty project"));
	}

	@Test
	public void testAddToPledged() {
		assertThat(project.getPledged(), is(22222));
		project.addToPledged(2222);
		assertThat(project.getPledged(), is(24444));
	}

}
