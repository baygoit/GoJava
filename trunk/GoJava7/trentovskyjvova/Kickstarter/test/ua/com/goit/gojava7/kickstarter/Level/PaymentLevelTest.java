package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PaymentLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 1";
	
	private List<Reward> rewards;
	private Category selectedCategory;
	private Project selectedProject;

	private QuestionDaoMemoryImpl questionDao = new QuestionDaoMemoryImpl();
	@Mock
	private RewardDao rewardDao = new RewardDaoMemoryImpl();
	@InjectMocks
	private Level paymentLevel = new PaymentLevel(questionDao, rewardDao);
	private Project project1;
	@Mock
	private ConsoleScanner consoleScanner;

	
	@Before 
	public void setUp() {
		Category category = new Category("Some Category", 1);
		project1 = new Project("proj 1", 4);
		selectedCategory = category;
		rewards = rewardDao.getRewards(project1.getId());
	}
	
	@Test
	public void testGenerateAnswer1() {
		String result = paymentLevel.generateAnswer(1, selectedCategory, project1);
		assertThat(result, containsString(""));
	}
	
	@Test
	public void testFillOutForm() {	
		when(consoleScanner.scanLine()).thenReturn("question");
		String result = paymentLevel.fillOutForm(project1, 2, consoleScanner);
		
		List<Question> questions = questionDao.getQuestions(project1.getId());
		
		assertThat(questions.size(), is(1));
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
		Category result = paymentLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise1() {
		when(rewardDao.size()).thenReturn(rewards.size());
		String result = paymentLevel.validateUserChoise(1, selectedCategory, project1);
		assertThat(result, is(""));
	}
	
	@Test
	public void testValidateUserChoise2() {
		when(rewardDao.size()).thenReturn(rewards.size());
		String result = paymentLevel.validateUserChoise(2, selectedCategory, project1);
		assertThat(result, is(ANSVER));
	}
	
	@Test
	public void testValidateUserChoiseMinus1() {
		when(rewardDao.size()).thenReturn(rewards.size());
		String result = paymentLevel.validateUserChoise(-1, selectedCategory, project1);
		assertThat(result, is(ANSVER));
	}
	

	@Test
	public void testGenerateAnswer2() {
		when(rewardDao.getRewards(project1.getId())).thenReturn(rewards);
		
		String result = paymentLevel.generateAnswer(2, selectedCategory, project1);
		assertThat(result, containsString("You selected 'to invest in the project"));
		assertThat(result, containsString(": own amount"));
	}
}
