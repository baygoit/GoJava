package ua.com.goit.gojava7.kickstarter.Level;

import static org.mockito.Matchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.QuestionDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PaymentLevelTest {
	private static final String ANSVER = "Please, enter the number between 0 and 3";

	private List<Reward> rewards;
	private Category selectedCategory;
	private Project selectedProject;
	private Reward reward;
	
	@Mock
	private QuestionDao questionDao;
	@Mock
	private RewardDao rewardDao;
	@InjectMocks
	private Level paymentLevel = new PaymentLevel(questionDao, rewardDao);
	@Mock
	private ConsoleScanner consoleScanner;

	@Before
	public void setUp() {
		selectedCategory = new Category();
		selectedCategory.setId(1);
		selectedCategory.setName("Some Category");
		selectedProject = new Project("proj 1", 1);

		reward = new Reward(1, 1);
		reward.setBenefit("benef 1");
		reward.setPledge(100);
		rewards = new ArrayList<Reward>();
		rewards.add(reward);
	}

	@Test
	public void testFindSelectedCategory() {
		Category result = paymentLevel
				.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}

	@Test
	public void testFindSelectedProject() {
		Project result = paymentLevel.findSelectedProject(0, selectedCategory,
				selectedProject);
		assertThat(result, is(selectedProject));
	}

	@Test
	public void testValidateUserChoise1() {
		when(rewardDao.size(selectedProject.getId())).thenReturn(rewards.size() + 1);
		String result = paymentLevel.validateUserChoise(1, selectedCategory,
				selectedProject);
		assertThat(result, is(""));
	}

	@Test
	public void testValidateUserChoise2() {
		when(rewardDao.size(selectedProject.getId())).thenReturn(rewards.size() + 1);
		String result = paymentLevel.validateUserChoise(4, selectedCategory,
				selectedProject);
		assertThat(result, is(ANSVER));
	}

	@Test
	public void testValidateUserChoiseMinus1() {
		when(rewardDao.size(selectedProject.getId())).thenReturn(rewards.size() + 1);
		String result = paymentLevel.validateUserChoise(-1, selectedCategory,
				selectedProject);
		assertThat(result, is(ANSVER));
	}

	@Test
	public void testFillOutForm() {

		when(consoleScanner.scanLine()).thenReturn("question");
		String result = paymentLevel.fillOutForm(selectedProject, 2,
				consoleScanner);

		verify(questionDao).addQuestion(any(Question.class));
		assertThat(result, is("Thank for your question!\n0 : back to project"));
	}

	@Test
	public void testGenerateAnswer1() {
		String result = paymentLevel.generateAnswer(1, selectedCategory,
				selectedProject);
		assertThat(result, is(""));
	}

	@Test
	public void testGenerateAnswer2() {
		when(rewardDao.getRewards(selectedProject.getId())).thenReturn(rewards);

		String result = paymentLevel.generateAnswer(2, selectedCategory,
				selectedProject);
		assertThat(result,
				containsString("You selected 'to invest in the project"));
		assertThat(result, containsString(": Pledge $100 - get benef 1"));
		assertThat(result, containsString(": own amount"));
		assertThat(result, containsString("0 :"));
	}
}
