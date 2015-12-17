package ua.com.goit.gojava7.kickstarter;

import org.junit.Before;
import org.junit.Ignore;
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
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
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
	private QuoteDao quoteDao;
	@Mock
	private CategoryDao categoryDao;
	@Mock
	private ProjectDao projectDao;
	@Mock
	private QuestionDao questionDao;
	@Mock
	private RewardDao rewardDao;

	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(quoteDao, categoryDao, projectDao, questionDao, rewardDao);

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

		projects.add(project1);
		projects.add(project2);

		categories.add(category1);
		categories.add(category2);
	}

	@Test
	public void testRunEntered0SaysFarewell() {
		when(quoteDao.get(1)).thenReturn(new Quote());
		when(consoleScanner.getInt(anyInt(), anyInt())).thenReturn(0);

		kickstarter.run();
		verify(quotePrinter).print(any(Quote.class));
		verify(printer).print(contains("List of categories:"));
		assertNull(kickstarter.chooseCategory(categoryDao));
		verify(printer).print(contains("See you soon!"));
	}

	@Test
	@Ignore
	public void testRunEntered1Has1Category() {
		// when(quoteDao.get(1)).thenReturn(new Quote());

		when(consoleScanner.getInt(anyInt(), anyInt())).thenReturn(1);
		// when(consoleScanner.getInt(0, projects.size())).thenReturn(0);
		// when(consoleScanner.getInt(0, categoryDao.size())).thenReturn(0);
		// when(categoryDao.get(0)).thenReturn(category1);

		kickstarter.run();
		verify(printer).print(contains("List of categories:"));
		verify(printer).print(contains("Choose a category by number ('0' for exit):"));
		// assertNull(kickstarter.chooseCategory(categoryDao));
		verify(printer).print(contains("Current category:"));
		// verify(printer).print(contains("List of projects:"));
		// verify(printer).print(contains("See you soon!"));
	}

	@Test
	@Ignore
	public void testRunEntered1Then1Has1Project() {
		when(categoryDao.getAll()).thenReturn(categories);
		when(categoryDao.size()).thenReturn(1);
		when(consoleScanner.getInt(0, categoryDao.size())).thenReturn(1, 1, 0, 0);
		when(categoryDao.get(0)).thenReturn(category1);
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.run();
		verify(printer, times(2)).print(contains("List of categories:"));
		verify(printer, times(3)).print(contains("Current category:"));
		verify(printer, times(2)).print(contains("List of projects:"));
		verify(printer).print(contains("Current project: #"));
		verify(printer).print(contains("See you soon!"));
	}

	@Test
	public void testChooseCategory() {

		kickstarter.chooseCategory(categoryDao);
		verify(printer).print(contains("List of categories:"));
		verify(printer).print(contains("Choose a category by number ('0' for exit): "));
	}

	@Test
	public void testSetCurrentCategoryEntered0() {
		when(consoleScanner.getInt(0, categoryDao.size())).thenReturn(0);

		assertNull(kickstarter.setCurrentCategory(categoryDao));
	}

	@Test
	public void testSetCurrentCategoryEntered1() {
		when(consoleScanner.getInt(0, categoryDao.size())).thenReturn(1);

		kickstarter.setCurrentCategory(categoryDao);
		verify(categoryDao).getByNumber(1);
	}

	@Test
	public void testChooseProject() {
		when(projectDao.getByCategory(anyInt())).thenReturn(projects);

		kickstarter.chooseProject(category1, projectDao);
		verify(printer).print(contains("Current category: Category1ForTest"));
		verify(printer).print(contains("Choose a project by number ('0' to choose another category): "));
	}

	@Test
	public void testSetCurrentProjectEntered0() {
		when(consoleScanner.getInt(0, projects.size())).thenReturn(0);

		assertNull(kickstarter.setCurrentProject(projects));
	}

	@Test
	public void testSetCurrentProjectEnteredCorrectNumber() {
		when(consoleScanner.getInt(0, projects.size())).thenReturn(1);

		assertNotNull(kickstarter.setCurrentProject(projects));
	}

	@Test
	public void testViewProject() {
		List<Question> questions = new ArrayList<>();

		when(questionDao.getByProject(anyInt())).thenReturn(questions);
		when(consoleScanner.getOption()).thenReturn("0");

		kickstarter.viewProject(project1);
		verify(projectPrinter).printFull(project1);
		verify(projectPrinter).printQuestions(questions);
	}

	@Test
	public void testChooseOptionOfProjectEnteger0() {
		when(consoleScanner.getOption()).thenReturn("0");

		assertTrue(kickstarter.chooseOptionOfProject(project1));
		verifyNoMoreInteractions(printer);
	}

	@Test
	public void testChooseOptionOfProjectEntegerA() {
		when(consoleScanner.getOption()).thenReturn("a");

		assertFalse(kickstarter.chooseOptionOfProject(project1));
		verify(printer).print(contains("Ask your question about project:"));
	}

	@Test
	public void testChooseOptionOfProjectEntegerB() {
		when(consoleScanner.getOption()).thenReturn("p");

		assertFalse(kickstarter.chooseOptionOfProject(project1));
		verify(printer).print(contains("Enter your name:"));
	}

	@Test
	public void testPledge() {
		when(consoleScanner.getString()).thenReturn("jjkljfhc").thenReturn("kjblvycyx");

		kickstarter.pledge(project1);

		verify(printer).print(contains("Enter your name:"));
		verify(printer).print(contains("Enter your card's number:"));
		verify(printer).print(contains("Let's choose your reward!"));
	}	

	@Test
	public void testChooseRewardEntered0() {
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward());

		when(rewardDao.getByProject(anyInt())).thenReturn(rewards);
		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(0);

		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Let's choose your reward!"));
		verify(printer, never()).print(contains("Amount of your donation is"));
		verifyNoMoreInteractions(projectDao);
	}
	
	@Test
	public void testChooseRewardEnteredNumberOfSomeReward() {
		Reward reward1 = new Reward();
		reward1.setAmount(10);
		List<Reward> rewardsInProject = new ArrayList<>();
		rewardsInProject.add(reward1);

		when(rewardDao.getByProject(anyInt())).thenReturn(rewardsInProject);
		when(consoleScanner.getInt(0, rewardsInProject.size() + 1)).thenReturn(1);

		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Let's choose your reward!"));
		verify(printer).print(contains("Amount of your donation is $10"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(projectDao).updatePledged(project1, 10);
	}

	@Test
	public void testChooseRewardEnteredLastNumber() {
		List<Reward> rewardsInProject = new ArrayList<>();
		rewardsInProject.add(new Reward());

		when(rewardDao.getByProject(anyInt())).thenReturn(rewardsInProject);		
		when(consoleScanner.getInt(0, rewardsInProject.size() + 1)).thenReturn(2);
		when(consoleScanner.getInt(1, 99900)).thenReturn(200);

		kickstarter.chooseReward(project1);
		verify(printer).print(contains("Let's choose your reward!"));
		verify(printer).print(contains("Enter amount from 1 to 99900"));
		verify(printer).print(contains("Amount of your donation is $200"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(projectDao).updatePledged(project1, 200);
	}
	

	@Test
	public void testAddQuestion() {
		assertThat(questionDao.size(), is(0));

		when(consoleScanner.getString()).thenReturn("NewQuestion");

		kickstarter.addQuestion(project1);
		verify(printer).print(contains("Ask your question about project:"));
		verify(questionDao).add(any(Question.class));
	}

	@Test
	public void testShutdown() {
		kickstarter.shutdown();
		verify(consoleScanner).close();
	}
}
