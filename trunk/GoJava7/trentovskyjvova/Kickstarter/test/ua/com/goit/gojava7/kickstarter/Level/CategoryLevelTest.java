package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.ProjectDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class CategoryLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 1";
	
	List<Project> projects;
	Category selectedCategory;
	@Mock
	ProjectDaoMemoryImpl projectDao = new ProjectDaoMemoryImpl();
	@InjectMocks
	Level categoryLevel = new CategoryLevel(projectDao, new PaymentDaoMemoryImpl());
	Project project;
	
	@Before 
	public void setUp() {
		projects = new ArrayList<Project>();
		Category category = new Category("Some Category", 1);
		project = new Project("proj 1", 1);
		//category.addProject(project);
		projects.add(project);
		//projects.add(new Category("Second Category", 2));
		selectedCategory = category;
	}
	
	@Test
	public void testFindSelectedCategory() {
		Category result = categoryLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise1() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(1, selectedCategory, project);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(2, selectedCategory, project);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(-1, selectedCategory, project);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		when(projectDao.getProjects(selectedCategory.getId())).thenReturn(projects);
		String result = categoryLevel.generateAnswer(0, selectedCategory, project);
		assertThat(result, containsString("You selected 'Some Category' category"));
		assertThat(result, containsString("proj 1"));
		assertThat(result, containsString("0 : main menu"));
	}
}
