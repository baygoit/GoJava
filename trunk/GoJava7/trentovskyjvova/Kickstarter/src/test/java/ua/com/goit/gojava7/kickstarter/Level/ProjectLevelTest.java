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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

@RunWith(MockitoJUnitRunner.class)
public class ProjectLevelTest {
	private static final String ANSVER = "Please, enter the correct number";
	
	private List<Question> questions;
	private Category selectedCategory;
	private Project selectedProject;
	
	@Mock
	private PaymentDao paymentDao;
	@Mock
	private QuestionDao questionDao;
	@InjectMocks
	private Level projectLevel = new ProjectLevel(paymentDao, questionDao);	
	
	@Before 
	public void setUp() {	
		selectedCategory = new Category();
		selectedCategory.setId(1);
		selectedCategory.setName("Some Category");
		selectedProject = new Project("proj 1", 1);
	}
	
	@Test
	public void testFillOutForm(){
		String result = projectLevel.fillOutForm(null, 1, null);
		assertThat(result, is(""));
	}
	
	@Test
	public void testFindSelectedCategory() {
		Category result = projectLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise1() {
		String result = projectLevel.validateUserChoise(1, selectedCategory, selectedProject);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		String result = projectLevel.validateUserChoise(3, selectedCategory, selectedProject);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		String result = projectLevel.validateUserChoise(-1, selectedCategory, selectedProject);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testGenerateAnswer() {
		Question question = new Question();
		question.setQuestionText("qwe");
		questions = new ArrayList<Question>();	
		questions.add(question);

		when(questionDao.getQuestions(1)).thenReturn(questions);
		
		String result = projectLevel.generateAnswer(0, selectedCategory, selectedProject);
		
		assertThat(result, containsString("You selected 'proj 1' project"));
		assertThat(result, containsString("daysToGo"));
		assertThat(result, containsString("Question: 'qwe'"));
		assertThat(result, containsString("1 : to invest in the project"));
		assertThat(result, containsString("2 : to ask a question"));
		assertThat(result, containsString("0 : to project list"));
	}
	
	@Test
	public void testFindSelectedProject() {
		Project result = projectLevel.findSelectedProject(0, selectedCategory, selectedProject);
		assertThat(result, is(selectedProject));
	}
}
