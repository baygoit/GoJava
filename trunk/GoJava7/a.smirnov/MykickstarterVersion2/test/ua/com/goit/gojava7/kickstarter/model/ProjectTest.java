package ua.com.goit.gojava7.kickstarter.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class ProjectTest {

	Project project1 = new Project("Football game", "The best game in the world", 10_000);
	Project project2 = new Project("Football game", "The worst game in the world", 12_000);
	
	@Test
	public void testProject() {
		Project project = new Project("A", "B", 1);
		StringBuilder result = new StringBuilder();
		result.
			append(project.getTitle()).
			append(project.getBriefDescription()).
			append(project.getRequiredAmountOfMoney());
		assertThat(result.toString(), is("AB1"));
	}

	@Test
	public void testGetTitle() {
		assertThat(project1.getTitle(), is("Football game"));
	}

	@Test
	public void testSetTitle() {
		project1.setTitle("Apolon");
		assertThat(project1.getTitle(), is("Apolon"));
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
	public void testGetFullDescription() {
		project1.addFullDescription("AAA");
		assertThat(project1.getFullDescription(), is("AAA"));
	}

	@Test
	public void testAddFullDescription() {
		project1.addFullDescription("BBB");
		assertThat(project1.getFullDescription(), is("BBB"));
	}

	@Test
	public void testGetRequiredAmountOfMoney() {
		assertThat(project1.getRequiredAmountOfMoney(), is(10000));
	}

	@Test
	public void testSetRequiredAmountOfMoney() {
		project1.setRequiredAmountOfMoney(2000);
		assertThat(project1.getRequiredAmountOfMoney(), is(2000));
	}

	@Test
	public void testGetCurrentAmoutOfMoney() {
		assertThat(project1.getCurrentAmoutOfMoney(), is(0));
	}

	@Test
	public void testAddToCurrentAmountOfMoney() {
		project1.addToCurrentAmountOfMoney(2000);
		assertThat(project1.getCurrentAmoutOfMoney(), is(2000));
	}

	@Test
	public void testGetLinkOnVideo() {
		assertThat(project1.getLinkOnVideo().length(), is(0));
	}

	@Test
	public void testAddLinkOnVideo() {
		project1.addLinkOnVideo("youtube.com");
		assertThat(project1.getLinkOnVideo(), is("youtube.com"));
	}

	@Test
	public void testGetAnswer() {
		assertThat(project1.getAnswer().length(), is(0));
	}

	@Test
	public void testAddAnswer() {
		project1.addAnswer("Hello");
		assertThat(project1.getAnswer(), is("Hello"));
	}

	@Test
	public void testGetQuestion() {
		assertThat(project1.getQuestion().length(), is(0));
	}

	@Test
	public void testAddQuestion() {
		project1.addQuestion("Question");
		assertThat(project1.getQuestion(), is("Question"));
	}

	@Test
	public void testGetExpiryDays() {
		assertThat(project1.getExpiryDays(), is(0));
	}
	
	@Test
	public void testSetExpiryDays() {
		project1.setExpiryDays(0, 0, 0);
		
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
		assertThat(result, is(0));
	}

}
