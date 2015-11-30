package ua.com.goit.gojava7.kickstarter;

import org.junit.Before;
import org.junit.Ignore;
//import org.junit.Ignore;
//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Printer;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.dao.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.ProjectStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuestionStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.QuoteStorage;
import ua.com.goit.gojava7.kickstarter.dao.storage.RewardStorage;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {

	@Mock
	private ConsoleScanner consoleScanner;
	@Mock
	private Printer printer;

	@Mock
	private CategoryPrinter categoryPrinter;
	@Mock
	private ProjectPrinter projectPrinter;
	@Mock
	private QuotePrinter quotePrinter;
	@Mock
	private QuoteStorage quoteStorage;
	@Mock
	private CategoryStorage categoryStorage;
	@Mock
	private ProjectStorage projectStorage;
	@Mock
	private QuestionStorage questionsStorage;
	@Mock
	private RewardStorage rewardStorage;

	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage, projectStorage, questionsStorage,
			rewardStorage);

	Category category1;
	Category category2;
	List<Category> categories = new ArrayList<>();
	Project project1;
	Project project2;
	List<Project> projects = new ArrayList<>();
	

	@Before
	public void setUp() {
		category1 = new Category();
		category1.setName("Category1ForTest");
		
		category2 = new Category();
		category2.setName("Category2ForTest");

		project1 = new Project();
		project1.setName("Project1ForTest");
		project1.setDescription("DescriptionTest1");
		project1.setGoal(100000);
		project1.setPledged(100);
		project1.setDaysToGo(10);
		project1.setHistory("HistoryTest1");
		project1.setLink("LinkTest1");
		project1.setCategoryName("Category1ForTest");

		project2 = new Project();
		project2.setName("Project2ForTest");
		project2.setDescription("DescriptionTest2");
		project2.setGoal(100000);
		project2.setPledged(100);
		project2.setDaysToGo(10);
		project2.setHistory("HistoryTest2");
		project2.setLink("LinkTest2");
		project2.setCategoryName("Category1ForTest");
		
		projects.add(project1);
		projects.add(project2);

		categories.add(category1);
		categories.add(category2);
	}

	@Test
	@Ignore
	public void testRunEntered0SaysFarewell() {
		Quote quote = new Quote();
		quote.setText("Quote");
		quote.setAuthor("Author");

		when(quoteStorage.getRandomQuote()).thenReturn(quote);
		when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(anyInt(), anyInt())).thenReturn(0);

		kickstarter.run();
		verify(quotePrinter).print(any(Quote.class));
		verify(printer).print(contains("List of categories:"));
		assertNull(kickstarter.chooseCategory(categoryStorage));
		verify(printer).print(contains("See you soon!"));
	}

	@Test
	@Ignore
	public void testRunEntered1Has1Category() {
		//when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(anyInt(), anyInt())).thenReturn(1, 1, 0);
		when(categoryStorage.get(0)).thenReturn(category1);
		kickstarter.run();
		verify(printer).print(contains("List of categories:"));
		verify(printer).print(contains("Choose a category by number ('0' for exit):"));
		verify(printer).print(contains("Current category:"));
		//verify(printer).print(contains("List of projects:"));
		verify(printer).print(contains("See you soon!"));
	}

	@Test
	@Ignore
	public void testRunEntered1Then1Has1Project() {		
		when(categoryStorage.getAll()).thenReturn(categories);
		when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(1, 1, 0, 0);
		when(categoryStorage.get(0)).thenReturn(category1);
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.run();
		verify(printer, times(2)).print(contains("List of categories:"));
		verify(printer, times(3)).print(contains("Current category:"));
		verify(printer, times(2)).print(contains("List of projects:"));
		verify(printer).print(contains("Current project: #"));
		verify(printer).print(contains("See you soon!"));
	}

	@Test
	@Ignore
	public void testChooseProject() {
		kickstarter.chooseProject(category1, projectStorage);
		verify(printer).print(contains("Current category: Category for test"));
		verify(printer).print(contains("Choose a project by number ('0' to choose another category): "));
	}

		@Test
	@Ignore
	public void testSetCurrentProjectEntered0() {	
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(0);
		assertNull(kickstarter.setCurrentProject(projects));
	}

	@Test
	@Ignore
	public void testSetCurrentProjectEnteredCorrectNumber() {		
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(1);
		assertNotNull(kickstarter.setCurrentProject(projects));
	}

	@Test
	@Ignore
	public void testViewProject() {
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.viewProject(project1);
		verify(projectPrinter).printFull(project1);
	}

	@Test
	@Ignore
	public void testChooseOptionOfProjectEnteger0() {
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.chooseOptionOfProject(project1);
		verifyNoMoreInteractions(printer);
	}

	@Test
	@Ignore
	public void testChooseOptionOfProjectEntegerA() {		
		when(consoleScanner.getOption()).thenReturn("a");
		kickstarter.chooseOptionOfProject(project1);
		verify(printer).print(contains("Ask your question about project:"));
	}

	@Test
	@Ignore
	public void testChooseOptionOfProjectEntegerB() {	
		when(consoleScanner.getOption()).thenReturn("b");
		kickstarter.chooseOptionOfProject(project1);
		verify(printer).print(contains("Enter your name:"));
	}

	@Test
	@Ignore
	public void testDonate() {		
		kickstarter.pledge(project1);
		when(consoleScanner.getString()).thenReturn("jjkljfhc").thenReturn("kjblvycyx");
		verify(printer).print(contains("Enter your name:"));
		verify(printer).print(contains("Enter your card's number:"));
	}

	@Test
	@Ignore
	public void testChooseRewardEnteredNumberOfSomeReward() {		
		Reward reward1 = new Reward();
		reward1.setAmount(10);
		reward1.setReward("ten bonuses");
		reward1.setProjectName("Project1ForTest");
		
		Reward reward2 = new Reward();
		reward2.setAmount(10);
		reward2.setReward("ten bonuses");
		reward2.setProjectName("Project2ForTest");
		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(reward1);
		rewards.add(reward2);
	
		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(1);
		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Let's choose your reward!"));
		verify(printer).print(contains("Amount of your donation is $10"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(printer).print(contains("Now collected: $110"));
	}

	@Test
	@Ignore
	public void testChooseRewardEntered0() {
		Reward reward1 = new Reward();
		reward1.setAmount(10);
		reward1.setReward("ten bonuses");
		reward1.setProjectName("Project1ForTest");
		
		Reward reward2 = new Reward();
		reward2.setAmount(10);
		reward2.setReward("ten bonuses");
		reward2.setProjectName("Project2ForTest");
		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(reward1);
		rewards.add(reward2);

		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(0);
		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Let's choose your reward!"));
		verifyNoMoreInteractions(printer);
	}

	@Test
	@Ignore
	public void testChooseRewardEnteredLastNumber() {
		Reward reward1 = new Reward();
		reward1.setAmount(10);
		reward1.setReward("ten bonuses");
		reward1.setProjectName("Project1ForTest");
		
		Reward reward2 = new Reward();
		reward2.setAmount(10);
		reward2.setReward("ten bonuses");
		reward2.setProjectName("Project2ForTest");
		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(reward1);
		rewards.add(reward2);

		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(3);
		when(consoleScanner.getInt(1, 99900)).thenReturn(200);
		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Enter amount from 1 to 99900"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(printer).print(contains("Now collected: $300"));
	}

	
	@Test
	@Ignore
	public void testAddQuestion() {
		/*
		when(consoleScanner.getString()).thenReturn("My question");
		assertThat(project.getQuestions().size(), is(0));
		kickstarter.addQuestion(project);
		verify(printer).print(contains("Ask your question about project:"));
		assertThat(project.getQuestions().get(0).getQuestion(), is("My question"));
		assertThat(project.getQuestions().get(0).getAnswer(), is("There is no answer yet"));
		assertNotNull(project.getQuestions().get(0).getTime());
		assertThat(project.getQuestions().size(), is(1));*/
	}

	@Test
	public void testShutdown() {
		kickstarter.shutdown();
		verify(consoleScanner).close();
	}

}
