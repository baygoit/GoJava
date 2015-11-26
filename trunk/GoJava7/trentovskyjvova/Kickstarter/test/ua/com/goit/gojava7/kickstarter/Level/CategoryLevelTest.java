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

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class CategoryLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 1";
	
	private List<Project> projects;
	private Category selectedCategory;
	private Project selectedProject;
	
	@Mock
	private ProjectDao projectDao;
	@Mock
	private PaymentDao paymentDao;
	@InjectMocks
	private Level categoryLevel = new CategoryLevel(projectDao, paymentDao);
	
	
	@Before 
	public void setUp() {
		selectedCategory = new Category("Some Category", 1);
		selectedProject = new Project("proj 1", 1);
		
		projects = new ArrayList<Project>();
		projects.add(selectedProject);
	}
	
	@Test
	public void testFillOutForm(){
		String result = categoryLevel.fillOutForm(null, 1, null);
		assertThat(result, is(""));
	}
	
	@Test
	public void testFindSelectedCategory() {
		Category result = categoryLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testFindSelectedProject() {
		when(projectDao.getProject(0)).thenReturn(selectedProject);
		Project result = categoryLevel.findSelectedProject(0, selectedCategory, null);
		assertThat(result, is(selectedProject));
	}
	
	@Test
	public void testValidateUserChoise1() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(1, selectedCategory, selectedProject);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(2, selectedCategory, selectedProject);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		when(projectDao.size()).thenReturn(projects.size());
		String result = categoryLevel.validateUserChoise(-1, selectedCategory, selectedProject);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		when(projectDao.getProjects(selectedCategory.getId())).thenReturn(projects);
		String result = categoryLevel.generateAnswer(0, selectedCategory, selectedProject);
		assertThat(result, containsString("You selected 'Some Category' category"));
		assertThat(result, containsString("proj 1"));
		assertThat(result, containsString("0 : main menu"));
	}
}
