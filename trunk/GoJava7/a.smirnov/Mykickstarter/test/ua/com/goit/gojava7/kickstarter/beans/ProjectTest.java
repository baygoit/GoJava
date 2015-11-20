package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Payment;
import ua.com.goit.gojava7.kickstarter.beans.Project;

public class ProjectTest {

	private String title = "Game FIFA 2020";
	private String briefDescription = "The best game in the world!";
	private int requiredSum = 100_000;
	
	private Project project;
	
	@Before
	public void setUp() throws Exception {
		project = new Project(title, briefDescription, requiredSum);
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
	public void testAddBriefDescription() {
		String newBriefDescription = "Good game";
		project.addBriefDescription(newBriefDescription);
	}

	@Test
	public void testGetFullDescription() {
		assertEquals(project.getFullDescription(), "----");
	}

	@Test
	public void testAddFullDescription() {
		String fullDescription = "a lot of text...";
		project.addFullDescription(fullDescription);
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
		assertThat(project.getUniqueID(), is(0));
	}

	@Test
	public void testSetUniqueID() {
		int uniqueID = 1;
		project.setUniqueID(uniqueID);
		assertThat(project.getUniqueID(), is(uniqueID));
	}

	@Test
	public void testGetSumProjectPayments() {
		int projectID = 1;
		
		List<Payment> payments = new ArrayList<>();
		Payment payment1 = new Payment("Anton", 1111, 100);
		payment1.setProjectID(projectID);
		payments.add(payment1);
		
		Payment payment2 = new Payment("Alex", 2222, 250);
		payment2.setProjectID(projectID);
		payments.add(payment2);
		
		project.setUniqueID(projectID);
		
		assertThat(project.getSumProjectPayments(payments), 
				is(payment1.getDonatingSum() + payment2.getDonatingSum()));
	}
}
