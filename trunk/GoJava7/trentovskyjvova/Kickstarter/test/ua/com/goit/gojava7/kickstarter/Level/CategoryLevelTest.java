package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class CategoryLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 1";
	
	List<Category> categories;
	Category selectedCategory;
	Level categoryLevel = new CategoryLevel();

	@Before 
	public void setUp() {
		categories = new ArrayList<Category>();
		Category category = new Category("Some Category");
		category.addProject(new Project("proj 1"));
		categories.add(category);
		categories.add(new Category("Second Category"));
		selectedCategory = category;
	}
	
	@Test
	public void testFindSelectedCategory1() {
		Category result = categoryLevel.findSelectedCategory(categories, 0, null);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testFindSelectedCategory2() {
		Category result = categoryLevel.findSelectedCategory(categories, 0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise1() {
		String result = categoryLevel.validateUserChoise(categories, 1, selectedCategory);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		String result = categoryLevel.validateUserChoise(categories, 2, selectedCategory);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		String result = categoryLevel.validateUserChoise(categories, -1, selectedCategory);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = categoryLevel.generateAnswer(categories, 0, selectedCategory);
		assertThat(result, containsString("You selected 'Some Category' category"));
		assertThat(result, containsString("proj 1"));
		assertThat(result, containsString("0 : main menu"));
	}
}
