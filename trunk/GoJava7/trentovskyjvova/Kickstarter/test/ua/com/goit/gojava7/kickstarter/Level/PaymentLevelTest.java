package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class PaymentLevelTest {
	
	List<Category> categories;
	Category selectedCategory;
	Level paymentLevel = new PaymentLevel();
	Project project1;
	@Mock
	ConsoleScanner consoleScanner;
	
	@Before 
	public void setUp() {
		categories = new ArrayList<Category>();
		Category category = new Category("Some Category");
		project1 = new Project("proj 1");
		project1.setPledged(10);
		category.addProject(project1);
		categories.add(category);
		categories.add(new Category("Second Category"));
		selectedCategory = category;
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = paymentLevel.generateAnswer(categories, 0, selectedCategory, project1);
		assertThat(result, containsString(""));
	}
	
	@Test
	public void testFillOutForm() {
		
		when(consoleScanner.scanLine()).thenReturn("name", "card");
		when(consoleScanner.scan()).thenReturn(290);
		String result = paymentLevel.fillOutForm(project1, 1, consoleScanner);
		
		assertThat(project1.getPledged(), is(300));
	}
}
