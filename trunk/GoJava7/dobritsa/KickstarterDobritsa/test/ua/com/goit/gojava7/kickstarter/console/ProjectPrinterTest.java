package ua.com.goit.gojava7.kickstarter.console;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPrinterTest {

	private ProjectPrinter projectPrinter = new ProjectPrinter();
	private PrintStream systemOut;

	@Before
	public void setUp() {
		systemOut = System.out;
	}

	@After
	public void tearDown() {
		System.setOut(systemOut);
	}

	@Test
	public void testPrint() {
		PrintStream printSteam = mock(PrintStream.class);
		System.setOut(printSteam);
		List<Question> questions = new ArrayList<Question>();
		questions.add(new Question(new java.util.Date ().toLocaleString(), "QuestionsTest"));
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
		questions.add(new Question(new java.util.Date ().toLocaleString(), "QuestionsTest"));
		Project project1 = new Project("NameTest", "DescriptionTest", 1000000, 10000, 10, "HistoryTest", "LinkTest");
		category.add(project1);
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);

		projectPrinter.printProjects(categories.get(0).getAll());
		verify(printSteam).println(contains("NameTest"));
		verify(printSteam).println(contains("DescriptionTest"));
		verify(printSteam).println(endsWith("10"));
	}

}
