package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;

public class ProjectTest {

	private Project project1;
	private Project project2;
	
	@Before
	public void setUp() throws Exception {
		project1 = new Project("Football game", "The best game in the world", 10_000);
		project2 = new Project("Soccer game", "The worst game in the world", 12_000);
	}
	
	@Test
	public void testProject() {
		Project project = new Project("1", "2", 3);
		StringBuilder result = new StringBuilder();
		result.
			append(project.getTitle()).
			append(project.getBriefDescription()).
			append(project.getRequiredAmountOfMoney());
		assertThat(result.toString(), is("123"));
	}

	@Test
	public void testGetTitle() {
		assertThat(project1.getTitle(), is("Football game"));
		assertThat(project2.getTitle(), is("Soccer game"));
	}

	@Test
	public void testSetTitle() {
		project1.setTitle("Apolon");
		project2.setTitle("Ukraine");
		assertThat(project1.getTitle(), is("Apolon"));
		assertThat(project2.getTitle(), is("Ukraine"));
	}

	@Test
	public void testGetBriefDescription() {
		assertThat(project1.getBriefDescription(), is("The best game in the world"));
	}

	@Test
	public void testAddBriefDescription() {
		project1.addBriefDescription("New project");
		assertThat(project1.getBriefDescription(), is("New project"));
	}

	@Test
	public void testAddAndGetFullDescription() {
		project1.addFullDescription("There are a lot of information...");
		assertThat(project1.getFullDescription(), is("There are a lot of information..."));
	}

	@Test
	public void testGetRequiredAmountOfMoney() {
		assertThat(project1.getRequiredAmountOfMoney(), is(10000));
	}

	@Test
	public void testSetRequiredAmountOfMoney() {
		project1.setRequiredAmountOfMoney(2000);
		project2.setRequiredAmountOfMoney(5000);
		assertThat(project1.getRequiredAmountOfMoney(), is(2000));
		assertThat(project2.getRequiredAmountOfMoney(), is(5000));
	}

	@Test
	public void testGetCurrentAmoutOfMoney() {
		assertThat(project1.getCurrentAmoutOfMoney(), is(0));
		assertThat(project2.getCurrentAmoutOfMoney(), is(0));
	}

	@Test
	public void testAddToCurrentAmountOfMoney() {
		project1.addMoneyToProject(2000);
		project2.addMoneyToProject(5000);
		assertThat(project1.getCurrentAmoutOfMoney(), is(2000));
		assertThat(project2.getCurrentAmoutOfMoney(), is(5000));
	}

	@Test (expected=NullPointerException.class)
	public void testGetLinkOnVideo() {
		assertThat(project1.getLinkOnVideo().length(), is(0));
		assertThat(project2.getLinkOnVideo().length(), is(0));
	}

	@Test
	public void testAddLinkOnVideo() {
		project1.addLinkOnVideo("youtube.com");
		project2.addLinkOnVideo("rutube.com");
		assertThat(project1.getLinkOnVideo(), is("youtube.com"));
		assertThat(project2.getLinkOnVideo(), is("rutube.com"));
	}
	
	@Test
	public void testGetDaysLeft() {
		TimeZone timeZone = TimeZone.getTimeZone("Europe/Kiev");
		Calendar currentCalendar = Calendar.getInstance();
		Date date = new Date();	
		currentCalendar.setTimeZone(timeZone);
		currentCalendar.setTime(date);
		
		int result = project1.getDaysLeft(currentCalendar.get(Calendar.DAY_OF_MONTH), 
				currentCalendar.get(Calendar.MONTH) + 1, currentCalendar.get(Calendar.YEAR));
		assertThat(result, is(0));
	}

	@Test
	public void testCompareTo() {
		int result = project1.getTitle().compareTo(project2.getTitle());
		assertTrue(result < 0);
	}

}
