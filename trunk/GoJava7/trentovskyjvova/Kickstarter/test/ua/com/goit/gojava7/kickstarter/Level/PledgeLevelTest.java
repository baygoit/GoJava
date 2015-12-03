package ua.com.goit.gojava7.kickstarter.Level;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ua.com.goit.gojava7.kickstarter.console.ConsoleScanner;
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PledgeLevelTest {
	private List<Reward> rewards;
	private Category selectedCategory;
	private Project selectedProject;
	private Reward reward;

	@Mock
	private PaymentDao paymentDao;
	@Mock
	private RewardDao rewardDao;
	@InjectMocks
	private Level pledgeLevel = new PledgeLevel(paymentDao, rewardDao);

	@Mock
	private ConsoleScanner consoleScanner;

	@Before
	public void setUp() {
		selectedCategory = new Category();
		selectedCategory.setId(1);
		selectedCategory.setName("Some Category");
		selectedProject = new Project("proj 1", 4);

		reward = new Reward(1, 1);
		reward.setBenefit("benef 1");
		reward.setPledge(100);
		rewards = new ArrayList<Reward>();
		rewards.add(reward);
	}

	@Test
	public void testGenerateAnswer() {
		String result = pledgeLevel.generateAnswer(0, selectedCategory,
				selectedProject);
		assertThat(result, containsString(""));
	}

	@Test
	public void testFindSelectedCategory() {
		Category result = pledgeLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}

	@Test
	public void testFindSelectedProject() {
		Project result = pledgeLevel.findSelectedProject(0, selectedCategory,
				selectedProject);
		assertThat(result, is(selectedProject));
	}

	@Test
	public void testValidateUserChoise() {
		String result = pledgeLevel.validateUserChoise(-1, selectedCategory,
				selectedProject);
		assertThat(result, is(""));
	}

	@Test
	public void testFillOutForm1() {
		when(rewardDao.size(selectedProject.getId()))
				.thenReturn(rewards.size());
		when(consoleScanner.scan()).thenReturn(10);
		when(consoleScanner.scanLine()).thenReturn("name", "card number");
		String result = pledgeLevel.fillOutForm(selectedProject, 2,
				consoleScanner);

		assertThat(result, is("Thank you!\n0 : back to rewards"));
	}

	@Test
	public void testFillOutForm2() {
		when(rewardDao.size(selectedProject.getId())).thenReturn(
				rewards.size());
		when(rewardDao.getReward(1, selectedProject.getId())).thenReturn(reward);
		when(consoleScanner.scanLine()).thenReturn("name", "card number");
		String result = pledgeLevel.fillOutForm(selectedProject, 1,
				consoleScanner);

		assertThat(result, is("Thank you!\n0 : back to rewards"));
	}
}
