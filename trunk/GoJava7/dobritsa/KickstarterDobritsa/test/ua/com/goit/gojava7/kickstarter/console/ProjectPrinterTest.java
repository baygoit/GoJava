package ua.com.goit.gojava7.kickstarter.console;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPrinterTest {

	private ProjectPrinter projectPrinter = new ProjectPrinter();
	String time = new Date().toString();
	private PrintStream defaultSystemOut;
	
	@Mock
	private PrintStream printSteam;

	@Before
	public void setUp() {
		defaultSystemOut = System.out;
		System.setOut(printSteam);
	}

	@After
	public void tearDown() {
		verifyNoMoreInteractions(printSteam);
		System.setOut(defaultSystemOut);
	}

	@Test
	public void testPrint() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(new java.util.Date ().toString(), "QuestionsTest"));
		Project project = new Project("NameTest", "DescriptionTest", 1000000, 10000, 10, "HistoryTest", "LinkTest");
		projectPrinter.printFull(project);
		verify(printSteam).println(contains("NameTest"));
	}

	@Test
	public void testPrintProjects() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		Category category = new Category("Category1");
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(new java.util.Date ().toString(), "QuestionsTest"));
		Project project1 = new Project("NameTest", "DescriptionTest", 1000000, 10000, 10, "HistoryTest", "LinkTest");
		category.add(project1);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);

		projectPrinter.printProjects(categories.get(0).getAll());
		verify(printSteam).println(contains("NameTest"));
		verify(printSteam).println(contains("DescriptionTest"));
		verify(printSteam).println(endsWith("10"));
	}
	
	@Test
	public void testPrintRewards() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);		
		List<Reward> rewards = new ArrayList<>();		
		rewards.add(new Reward(10, "ten Bonuses"));
		rewards.add(new Reward(20, "twenty Bonuses"));		
		projectPrinter.printRewards(rewards);
		verify(printSteam).println(contains("Type:"));
		verify(printSteam).println(contains("10"));
		verify(printSteam).println(contains("twenty Bonuses"));
		verify(printSteam).println(contains("No thanks, I just want to help the project."));
	}
	
	@Test
	public void testPrintEmptyRewards() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);		
		List<Reward> rewards = new ArrayList<>();
		projectPrinter.printRewards(rewards);
		verify(printSteam).println(contains("There are no rewards. You can just help the project."));	
	}
	
	@Test
	public void testPrintQuestions() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);		
		List<Question> questions = new ArrayList<>();		
		questions.add(new Question(time, "Test Question 1", "Test Answer 1"));
		questions.add(new Question(time, "Test Question 2"));
		projectPrinter.printQuestions(questions);
		verify(printSteam, times(2)).println(contains("Question:"));
		verify(printSteam).println(contains("Test Question 1"));
		verify(printSteam, times(2)).println(contains(time));
		verify(printSteam).println(endsWith("There is no answer yet"));
	}
	
	@Test
	public void testPrintEmptyQuestions() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);		
		List<Question> questions = new ArrayList<>();
		projectPrinter.printQuestions(questions);
		verify(printSteam).println(contains("There are no questions yet"));	
	}
	
}
