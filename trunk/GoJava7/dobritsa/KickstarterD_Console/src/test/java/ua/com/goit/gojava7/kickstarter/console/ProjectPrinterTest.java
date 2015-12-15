package ua.com.goit.gojava7.kickstarter.console;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPrinterTest {

	private ProjectPrinter projectPrinter = new ProjectPrinter();
	Project project = new Project();
	List<Project> projects = new ArrayList<>();

	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {		
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		// verifyNoMoreInteractions(printSteam);
	}

	@Test
	public void testPrintProjects() {
		project.setName("TestName1");
		Project project2 = new Project();
		project2.setName("TestName2");
		projects.add(project2);
		projects.add(project2);

		projectPrinter.printProjects(projects);
		verify(printSteam).println(contains("1:"));
		verify(printSteam, times(2)).println(contains("TestName"));
	}

	@Test
	public void testPrintShort() {
		project.setName("TestName1");
		project.setDaysToGo(3);
		project.setHistory("TestHistory1");

		projectPrinter.printFull(project);
		verify(printSteam).println(contains("TestName1"));
		verify(printSteam).println(endsWith("3"));

	}

	@Test
	public void testPrintFull() {
		project.setName("TestName1");
		project.setHistory("TestHistory1");
		project.setLink("TestLink1");
		Project project2 = new Project();
		project2.setName("TestName2");

		projectPrinter.printFull(project);
		verify(printSteam).println(contains("TestName1"));
		verify(printSteam).println(contains("TestHistory1"));
		verify(printSteam).println(contains("TestLink1"));
	}

	@Test
	public void testPrintRewards() {
		List<Reward> rewards = new ArrayList<>();
		Reward reward1 = new Reward();
		reward1.setAmount(1);
		reward1.setReward("OneTestReward");
		Reward reward2 = new Reward();
		reward2.setAmount(2);
		reward2.setReward("TwoTestRewards");
		rewards.add(reward1);
		rewards.add(reward2);

		projectPrinter.printRewards(rewards);
		verify(printSteam).println(contains("Type:"));
		verify(printSteam).println(contains("1"));
		verify(printSteam).println(contains("TwoTestRewards"));
		verify(printSteam).println(contains("No thanks, I just want to help the project."));
	}

	@Test
	public void testPrintEmptyRewards() {
		List<Reward> rewards = new ArrayList<>();
		
		projectPrinter.printRewards(rewards);
		verify(printSteam).println(contains("There are no rewards. You can just help the project."));
		verify(printSteam).println(endsWith("0: To choose another project"));
	}

	@Test

	public void testPrintQuestions() {
		List<Question> questions = new ArrayList<>();
		questions.add(new Question());
		questions.add(new Question());

		projectPrinter.printQuestions(questions);
		verify(printSteam, times(2)).println(contains("Question:"));
	}

	@Test
	public void testPrintEmptyQuestions() {
		List<Question> questions = new ArrayList<>();

		projectPrinter.printQuestions(questions);
		verify(printSteam).println(contains("There are no questions yet"));
	}
}
