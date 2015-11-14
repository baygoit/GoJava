package ua.com.goit.gojava7.kickstarter.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class ProjectTest {
	Project project = new Project();
	@Test
	public void testSetAndGetMoneyNeeded() {
		project.setMoneyNeeded(1000.0);
		assertThat(project.getMoneyNeeded(), is(1000.0));
	}


	@Test
	public void testProject() {
		assertNotNull(project);
	}


	@Test
	public void testProject4(){
		Category projectCategory = new Category();
		LocalDateTime now = LocalDateTime.now();
		project = new Project("1", "2", projectCategory, now);
		assertThat(project.getProjectName(), is("1"));
		assertThat(project.getProjectDescription(),is("2"));
		assertThat(project.getProjectCategory(),is(projectCategory));
		assertThat(project.getEnddate(), is(now));
	}
	
	@Test
	public void testGetProjectEndTime(){
		Category projectCategory = new Category();
		LocalDateTime now = LocalDateTime.now().plusDays(14).minusHours(1);
		project = new Project("1", "2", projectCategory, now);
		assertThat(project.getProjectEndTime(), is("13 дней до окончания"));
		
		project.setEnddate(LocalDateTime.now().plusHours(4).minusMinutes(1));
		assertThat(project.getProjectEndTime(), is("239 минут до окончания"));
		
		project.setEnddate(LocalDateTime.now().plusHours(4));
		assertThat(project.getProjectEndTime(), is("4 часов до окончания"));
	}

	@Test
	public void testAddBacker() {
		project.addBacker(new User(), 4321.0);
		assertThat(project.getBackers().size(), is(1));
	}

	
	@Test
	public void testGetFundedPercentage() {
		project.addBacker(new User(), 50000.0);
		project.setMoneyNeeded(100000.0);
		assertThat(project.getFundedPercentage(), is("50.0%"));
	}

	@Test
	public void testSetGetProjectName() {
		project.setProjectName("Test");
		assertThat(project.getProjectName(), is("Test"));
	}

	@Test
	public void testSetProjectName() {
		project.setProjectName("One");
		assertNotNull(project.getProjectName());
	}

	@Test
	public void testGetProjectDescription() {
		project.setProjectDescription("Descrption");
		assertThat(project.getProjectDescription(), is("Descrption"));
	}

	@Test
	public void testSetProjectDescription() {
		project.setProjectDescription("TestX");
		assertNotNull(project.getProjectDescription());
	}

	@Test
	public void testGetMoneyPledged() {
		project.addBacker(new User(), 50000.0);
		assertThat(project.getMoneyPledged(), is(50000.0));
	}

	@Test
	public void testGetProjectCategory() {
		Category cat = new Category("NameCategory", 1);
		project.setProjectCategory(cat);
		assertThat(project.getProjectCategory(), is(cat));
	}



	@Test
	public void testGetEnddate() {
		LocalDateTime loc = LocalDateTime.now();
		project.setEnddate(loc);
		assertThat(project.getEnddate(),is(loc));
	}


	@Test
	public void testGetProjectHistory() {
		String projectHistory = "History";
		project.setProjectHistory(projectHistory);
		assertThat(project.getProjectHistory(), is(projectHistory));
	}


	@Test
	public void testGetQuestionsAndAnswers() {
		Map<String,String> qa = new HashMap<String,String>();
		project.setQuestionsAndAnswers(qa);
		assertThat(project.getQuestionsAndAnswers(),is(qa));
	}


	@Test
	public void testGetDemoLink() {
		String demoLink = "Link";
		project.setDemoLink(demoLink);
		assertThat(project.getDemoLink(),is(demoLink));
	}


}
