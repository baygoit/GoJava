package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.domain.Category;

public class MenuLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 1";
	
	List<Category> categories;
	Category selectedCategory;
	Level menuLevel = new MenuLevel();

	@Before 
	public void setUp() {
		categories = new ArrayList<Category>();
		Category category = new Category("Some Category");
		categories.add(category);
	}
	
	@Test
	public void testFindSelectedCategory() {
		Category result = menuLevel.findSelectedCategory(new ArrayList<Category>(), 1, selectedCategory);
		assertThat(result, nullValue());
	}

	@Test
	public void testValidateUserChoise1() {
		String result = menuLevel.validateUserChoise(categories, 1, selectedCategory);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		String result = menuLevel.validateUserChoise(categories, 2, selectedCategory);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		String result = menuLevel.validateUserChoise(categories, -1, selectedCategory);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = menuLevel.generateAnswer(categories, 0, selectedCategory, null);
		assertThat(result, containsString("1 : Some Category"));
		assertThat(result, containsString("0 : Exit from application"));
		assertThat(result, containsString("Select a category"));
	}
	
	
}
