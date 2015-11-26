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
import ua.com.goit.gojava7.kickstarter.dao.PaymentDao;
import ua.com.goit.gojava7.kickstarter.dao.RewardDao;
import ua.com.goit.gojava7.kickstarter.dao.memory.PaymentDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.QuestionDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.dao.memory.RewardDaoMemoryImpl;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Payment;
import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;
import ua.com.goit.gojava7.kickstarter.domain.Reward;

@RunWith(MockitoJUnitRunner.class)
public class PledgeLevelTest {
	private List<Reward> rewards;
	
	private PaymentDao paymentDao = new PaymentDaoMemoryImpl();
	@Mock
	private RewardDao rewardDao = new RewardDaoMemoryImpl();
	@InjectMocks
	private Level pledgeLevel = new PledgeLevel(paymentDao, rewardDao);
	private Project selectedProject;
	private Category selectedCategory;
	
	@Mock
	private ConsoleScanner consoleScanner;
	
	@Before 
	public void setUp() {
		selectedProject = new Project("proj 1", 4);
		selectedCategory = new Category("Some Category", 1);;
		rewards = rewardDao.getRewards(selectedProject.getId());
	}
	
	@Test
	public void testGenerateAnswer() {
		String result = pledgeLevel.generateAnswer(1, selectedCategory, selectedProject);
		assertThat(result, containsString(""));
	}
	
	@Test
	public void testFindSelectedProject() {	
		selectedProject = new Project("name", 1);
		Project result = pledgeLevel.findSelectedProject(0, selectedCategory, selectedProject);
		assertThat(result, is(selectedProject));
	}
	
	@Test
	public void testFindSelectedCategory() {	
		selectedCategory = new Category("name", 1);
		Category result = pledgeLevel.findSelectedCategory(0, selectedCategory);
		assertThat(result, is(selectedCategory));
	}
	
	@Test
	public void testValidateUserChoise() {
		String result = pledgeLevel.validateUserChoise(-1, selectedCategory, selectedProject);
		assertThat(result, is(""));
	}
	
	@Test
	public void testFillOutForm() {	
		when(rewardDao.size()).thenReturn(1);
		when(consoleScanner.scan()).thenReturn(10);
		when(consoleScanner.scanLine()).thenReturn("name", "card number");
		String result = pledgeLevel.fillOutForm(selectedProject, 2, consoleScanner);
		
		int pledged = paymentDao.getPledged(selectedProject.getId());
		
		assertThat(pledged, is(10));
		assertThat(result, is("Thank you!\n0 : back to rewards"));
	}
}
