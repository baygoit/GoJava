package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.storage_in_files.PaymentStorage;

public class ProjectTest {

	private String title = "Game FIFA 2020";
	private String briefDescription = "The best game in the world!";
	private int requiredSum = 100_000;
	private int projectID = 2;
	
	private Project project;
	
	@Before
	public void setUp() throws Exception {
		project = new Project(title, briefDescription, requiredSum);
		project.setUniqueID(projectID);
	}

	@Test
	public void testProject() {
		assertThat(project.getTitle(), is(title));
		assertThat(project.getBriefDescription(), is(briefDescription));
		assertThat(project.getRequiredSum(), is(requiredSum));
	}

	@Test
	public void testGetTitle() {
		assertThat(project.getTitle(), is(title));
	}

	@Test
	public void testSetTitle() {
		String newTitle = "Soccer game";
		project.setTitle(newTitle);
		assertThat(project.getTitle(), is(newTitle));
	}

	@Test
	public void testGetBriefDescription() {
		assertThat(project.getBriefDescription(), is(briefDescription));
	}

	@Test
	public void testSetBriefDescription() {
		String newBriefDescription = "Good game";
		project.setBriefDescription(newBriefDescription);
	}

	@Test
	public void testGetFullDescription() {
		assertEquals(project.getFullDescription(), "----");
	}

	@Test
	public void testSetFullDescription() {
		String fullDescription = "a lot of text...";
		project.setFullDescription(fullDescription);
		assertThat(project.getFullDescription(), is(fullDescription));
	}

	@Test
	public void testGetRequiredSum() {
		assertThat(project.getRequiredSum(), is(requiredSum));
	}

	@Test
	public void testSetRequiredSum() {
		int money = 20_000;
		project.setRequiredSum(money);
		assertThat(project.getRequiredSum(), is(money));
	}

	@Test
	public void testGetCollectedSum() {
		assertThat(project.getCollectedSum(), is(0));
	}

	@Test
	public void testSetCollectedSum() {
		int money = 100;
		project.setCollectedSum(money);
		assertThat(project.getCollectedSum(), is(money));
	}

	@Test
	public void testGetVideoLink() {
		assertEquals(project.getVideoLink(), "----");
	}

	@Test
	public void testSetVideoLink() {
		String videoLink = "youtube.com";
		project.setVideoLink(videoLink);
		assertThat(project.getVideoLink(), is(videoLink));
	}

	@Test
	public void testGetCategoryID() {
		assertThat(project.getCategoryID(), is(0));
	}

	@Test
	public void testSetCategoryID() {
		int categoryID = 1;
		project.setCategoryID(categoryID);
		assertThat(project.getCategoryID(), is(categoryID));
	}

	@Test
	public void testGetUniqueID() {
		assertThat(project.getUniqueID(), is(2));
	}

	@Test
	public void testSetUniqueID() {
		int uniqueID = 1;
		project.setUniqueID(uniqueID);
		assertThat(project.getUniqueID(), is(uniqueID));
	}
}
