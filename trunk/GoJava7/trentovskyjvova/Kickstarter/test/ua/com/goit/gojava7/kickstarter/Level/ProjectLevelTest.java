package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectLevelTest {

	private static final String ANSVER = "Please, enter the correct number";
	
	List<Category> categories;
	Category selectedCategory;
	Level projectLevel = new ProjectLevel(new PaymentDaoMemoryImpl(), new QuestionDaoMemoryImpl());
	Project project1;
	
	@Before 
	public void setUp() {
		categories = new ArrayList<Category>();
		Category category = new Category("Some Category", 1);
		project1 = new Project("proj 1", 1);

		categories.add(category);
		categories.add(new Category("Second Category", 1));
		selectedCategory = category;
	}
	
	@Test
	public void testFindSelectedCategory() {
		Category result = projectLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise1() {
		String result = projectLevel.validateUserChoise(1, selectedCategory, project1);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		String result = projectLevel.validateUserChoise(3, selectedCategory, project1);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		String result = projectLevel.validateUserChoise(-1, selectedCategory, project1);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = projectLevel.generateAnswer(0, selectedCategory, project1);
		assertThat(result, containsString("You selected 'proj 1' project"));
		assertThat(result, containsString("daysToGo"));
		assertThat(result, containsString("1 : to invest in the project"));
		assertThat(result, containsString("0 : to project list"));
	}
	
	@Test
	public void testFindSelectedProject() {
		Project result = projectLevel.findSelectedProject(0, selectedCategory, project1);
		assertThat(result, is(project1));
	}
}
