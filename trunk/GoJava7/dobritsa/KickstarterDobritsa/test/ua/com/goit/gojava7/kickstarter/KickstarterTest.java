package ua.com.goit.gojava7.kickstarter;

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
import ua.com.goit.gojava7.kickstarter.dao.QuoteDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.domain.Reward;
import ua.com.goit.gojava7.kickstarter.old.CategoryDao;

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
	private QuoteDao quoteStorage;
	@Mock
	private CategoryDao categoryStorage;
	
	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage);
	
	@Test	
	public void testRunEntered0SaysFarewell() {
		when(quoteStorage.getRandomQuote()).thenReturn(new Quote("Quote", "Author"));		
		when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(0);
		
		kickstarter.run();
		verify(quotePrinter).print(any(Quote.class));		
		verify(printer).print(contains("List of categories:"));		
		assertNull(kickstarter.chooseCategory(categoryStorage));
		verify(printer).print(contains("See you soon!"));			
	}
	
	@Test		
	public void testRunEntered1Has1Category() {
		Category category = new Category("Category1 for test");	
		when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(1, 0, 0);
		when(categoryStorage.get(0)).thenReturn(category);
		kickstarter.run();
		verify(printer, times(2)).print(contains("List of categories:"));	
		verify(printer).print(contains("Current category:"));	
		verify(printer).print(contains("List of projects:"));				
		verify(printer).print(contains("See you soon!"));	
	}
	
	@Test		
	public void testRunEntered1Then1Has1Project() {		
		Category category = new Category("Category for test");
		category.add(new Project("NameTest1", "DescriptionTest1", 100000, 100, 10, "HistoryTest1", "LinkTest1"));	
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		
		when(categoryStorage.getAll()).thenReturn(categories);
		when(categoryStorage.size()).thenReturn(1);
		when(consoleScanner.getInt(0, categoryStorage.size())).thenReturn(1, 1, 0, 0);
		when(categoryStorage.get(0)).thenReturn(category);
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.run();
		verify(printer, times(2)).print(contains("List of categories:"));	
		verify(printer, times(3)).print(contains("Current category:"));	
		verify(printer, times(2)).print(contains("List of projects:"));				
		verify(printer).print(contains("Current project: #"));		
		verify(printer).print(contains("See you soon!"));			
	}
	
	@Test
	public void testChooseProject() {
		Category category = new Category("Category for test");
		category.add(new Project("NameTest1", "DescriptionTest1", 100000, 100, 10, "HistoryTest1", "LinkTest1"));	
		category.add(new Project("NameTest2", "DescriptionTest2", 100000, 100, 10, "HistoryTest2", "LinkTest2"));
		
		kickstarter.chooseProject(category);
		verify(printer).print(contains("Current category: Category for test"));
		verify(printer).print(contains("Choose a project by number ('0' to choose another category): "));
	}
	
	@Test
	public void testPrintAboutProjects() {
		Category category = new Category("Category for test");
		category.add(new Project("NameTest1", "DescriptionTest1", 100000, 100, 10, "HistoryTest1", "LinkTest1"));	
		category.add(new Project("NameTest2", "DescriptionTest2", 100000, 100, 10, "HistoryTest2", "LinkTest2"));
		
		kickstarter.printAboutProjects(category);
		verify(printer).print(contains("Current category: Category for test"));
		verify(projectPrinter).printProjects(category.getAll());
		verify(printer).print(contains("Choose a project by number ('0' to choose another category): "));
	}	
	
	@Test
	public void testSetCurrentProjectEntered0() {
		Category category = new Category("Category for test");
		category.add(new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest"));	
		
		when(consoleScanner.getInt(0, category.size())).thenReturn(0);
		assertNull(kickstarter.setCurrentProject(category));
	}
	
	@Test
	public void testSetCurrentProjectEnteredCorrectNumber() {
		Category category = new Category("Category for test");
		category.add(new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest"));	
		
		when(consoleScanner.getInt(0, category.size())).thenReturn(1);
		assertNotNull(kickstarter.setCurrentProject(category));
	}
	
	@Test
	public void testViewProject() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");	
		
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.viewProject(project);
		verify(projectPrinter).printFull(project);
	}
	
	@Test
	public void testChooseOptionOfProjectEnteger0() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");	
		
		when(consoleScanner.getOption()).thenReturn("0");
		kickstarter.chooseOptionOfProject(project);
		verifyNoMoreInteractions(printer);
	}
	
	@Test
	public void testChooseOptionOfProjectEntegerA() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");	
		when(consoleScanner.getOption()).thenReturn("a");
		kickstarter.chooseOptionOfProject(project);
		verify(printer).print(contains("Ask your question about project:"));	
	}
	
	@Test	
	public void testChooseOptionOfProjectEntegerB() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");	
		when(consoleScanner.getOption()).thenReturn("b");
		kickstarter.chooseOptionOfProject(project);
		verify(printer).print(contains("Enter your name:"));	
	}
	
	@Test
	public void testDonate() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");	
		kickstarter.pledge(project);
		when(consoleScanner.getString()).thenReturn("jjkljfhc").thenReturn("kjblvycyx");
		verify(printer).print(contains("Enter your name:"));
		verify(printer).print(contains("Enter your card's number:"));
	}

	@Test
	public void testChooseRewardEnteredNumberOfSomeReward() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward(10, "ten bonuses"));
		rewards.add(new Reward(20, "twenty bonuses"));
		project.setRewards(rewards);
		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(1);
		kickstarter.chooseReward(project);
		verify(printer).print(contains("Let's choose your reward!"));
		verify(printer).print(contains("Amount of your donation is $10"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(printer).print(contains("Now collected: $110"));
	}
	
	@Test
	public void testChooseRewardEntered0() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward(10, "ten bonuses"));
		rewards.add(new Reward(20, "twenty bonuses"));
		project.setRewards(rewards);
		
		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(0);
		kickstarter.chooseReward(project);
		verify(printer).print(contains("Let's choose your reward!"));
		verifyNoMoreInteractions(printer);
	}	
	
	@Test
	public void testChooseRewardEnteredLastNumber() {
		Project project = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");		
		List<Reward> rewards = new ArrayList<>();
		rewards.add(new Reward(10, "ten bonuses"));
		rewards.add(new Reward(20, "twenty bonuses"));
		project.setRewards(rewards);
		
		when(consoleScanner.getInt(0, rewards.size() + 1)).thenReturn(3);
		when(consoleScanner.getInt(1, 99900)).thenReturn(200);
		kickstarter.chooseReward(project);
		verify(printer).print(contains("Enter amount from 1 to 99900"));
		verify(printer).print(contains("It was collected before: $100"));
		verify(printer).print(contains("Now collected: $300"));
	}	
	
	
	@Test
	public void testDoDonate() {	
		Project currentProject = new Project("NameTest", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");
		
		assertThat(currentProject.getPledged(), is(100));
		kickstarter.pledge(currentProject, 20);
		assertThat(currentProject.getPledged(), is(120));
	}
	
	@Test
	public void testAddQuestion() {		
		Project project = new Project("Name Of Test Project", "DescriptionTest", 100000, 100, 10, "HistoryTest", "LinkTest");
		project.setQuestions(new ArrayList<Question>());
		
		when(consoleScanner.getString()).thenReturn("My question");
		assertThat(project.getQuestions().size(), is(0));
		kickstarter.addQuestion(project);
		verify(printer).print(contains("Ask your question about project:"));
		assertThat(project.getQuestions().get(0).getQuestion(), is("My question"));
		assertThat(project.getQuestions().get(0).getAnswer(), is("There is no answer yet"));
		assertNotNull(project.getQuestions().get(0).getTime());
		assertThat(project.getQuestions().size(), is(1));
	}
	
	@Test
	public void testShutdown() {
		kickstarter.shutdown();
		verify(consoleScanner).close();
	}

}
