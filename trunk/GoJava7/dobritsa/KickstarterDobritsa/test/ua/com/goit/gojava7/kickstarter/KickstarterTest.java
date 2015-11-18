package ua.com.goit.gojava7.kickstarter;

import org.junit.After;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava7.kickstarter.console.CategoryPrinter;
import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.console.Printer;
import ua.com.goit.gojava7.kickstarter.console.ProjectPrinter;
import ua.com.goit.gojava7.kickstarter.console.QuotePrinter;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Quote;
import ua.com.goit.gojava7.kickstarter.storage.CategoryStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuoteStorage;

@RunWith(MockitoJUnitRunner.class)
public class KickstarterTest {

	private PrintStream systemOut;
	
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
	//@Mock
	private QuoteStorage quoteStorage;
	@Mock
	private CategoryStorage categoryStorage;
	
	@InjectMocks
	private Kickstarter kickstarter = new Kickstarter(quoteStorage, categoryStorage);
	
	@Before
	public void setUp() {
		systemOut = System.out;		
	}
	
	@After
	public void tearDown() {
		System.setOut(systemOut);
	}
	
	@Test
	public void testAsk() {		
		Project currentProject = new Project();
		currentProject.setName("It it a project");
		List<Question> questions = new ArrayList<>();
		when(consoleScanner.getString()).thenReturn("My question");
	//	kickstarter.ask();
		//assertThat(currentProject.getName(), is("It it a project"));	
		//verify(printer).print(contains("Ask your question about project:"));
		
		
		//when(consoleScanner.getInt(0, 0)).thenReturn(0, 0);
		//kickstarter.chooseCategory();		
		//verify(printSteam).println(contains("List"));
		//verify(printSteam).println(contains("_____"));
		//verify(printSteam).println(contains("1:"));
		//verify(printSteam).println(contains("exit"));
		//verify(printSteam).println(contains("Category2"));
		//verify(categoryPrinter).printCategories(anyListOf(Category.class));
		//verify(categoryPrinter).printCategories(anyListOf(Category.class));
		//verify(printSteam).println(contains("soon"));
	}
	
	@Test
	public void testShutdown() {
		kickstarter.shutdown();

		verify(consoleScanner).close();
	}

}
