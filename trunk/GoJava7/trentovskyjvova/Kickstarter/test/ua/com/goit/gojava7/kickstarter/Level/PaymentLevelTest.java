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
import ua.com.goit.gojava7.kickstarter.storage.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.storage.QuestionStorage;

@RunWith(MockitoJUnitRunner.class)
public class PaymentLevelTest {
	
	List<Category> categories;
	Category selectedCategory;
	Project selectedProject;
	Level paymentLevel = new PaymentLevel();
	Project project1;
	@Mock
	ConsoleScanner consoleScanner;
	QuestionStorage questionStorage = new QuestionStorage();
	
	@Before 
	public void setUp() {
		categories = new ArrayList<Category>();
		Category category = new Category("Some Category", 1);
		project1 = new Project("proj 1", 1);
		//project1.setPledged(10);
		category.addProject(project1);
		categories.add(category);
		categories.add(new Category("Second Category", 2));
		selectedCategory = category;
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = paymentLevel.generateAnswer(categories, 1, selectedCategory, project1);
		assertThat(result, containsString(""));
	}
	
	@Test
	public void testFillOutForm() {	
		when(consoleScanner.scanLine()).thenReturn("question");
		String result = paymentLevel.fillOutForm(project1, 2, consoleScanner, questionStorage, null);
		
		assertThat(project1.getQuestions().size(), is(1));
		assertThat(result, is("Thank for your question!\n0 : back to project"));
	}
	
	@Test
	public void testFindSelectedProject() {	
		selectedProject = new Project("name", 1);
		Project result = paymentLevel.findSelectedProject(0, selectedCategory, selectedProject);
		assertThat(result, is(selectedProject));
	}
	
	@Test
	public void testFindSelectedCategory() {	
		selectedCategory = new Category("name", 1);
		Category result = paymentLevel.findSelectedCategory(categories, 0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
/*  move to another test class
	@Test
	public void testFillOutForm() {
		
		when(consoleScanner.scanLine()).thenReturn("name", "card");
		when(consoleScanner.scan()).thenReturn(290);
		String result = paymentLevel.fillOutForm(project1, 2, consoleScanner, null, paymentStorage);
		
		assertThat(project1.getPledged(), is(290));
	}*/
}
