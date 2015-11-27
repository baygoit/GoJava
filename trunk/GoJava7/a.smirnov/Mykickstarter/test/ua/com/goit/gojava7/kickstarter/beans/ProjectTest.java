package ua.com.goit.gojava7.kickstarter.beans;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.goit.gojava7.kickstarter.beans.Project;

public class ProjectTest {

	private String title = "Game FIFA 2020";
	private String briefDescription = "Project brief description...";
	private String fullDescription = "Project full description...";
	private String videoLink = "youtube.com";
	private int requiredSum = 100_000;
	private int collectedSum = 20_000;
	private int uniqueID = 1;
	private int categoryID = 2;
	private Project project = new  Project();
	
	@Before
	public void setUp() throws Exception {
		project.setTitle(title);
		project.setBriefDescription(briefDescription);
		project.setFullDescription(fullDescription);
		project.setRequiredSum(requiredSum);
		project.setCollectedSum(collectedSum);
		project.setUniqueID(uniqueID);
		project.setCategoryID(categoryID);
		project.setVideoLink(videoLink);
	}

	@Test
	public void testProject() {
		Project myProject = new Project();
		assertThat(myProject.getTitle().length(), is(0));
		assertThat(myProject.getBriefDescription().length(), is(0));
		assertThat(myProject.getFullDescription().length(), is(0));
		assertThat(myProject.getVideoLink().length(), is(0));
		assertThat(myProject.getRequiredSum(), is(0));
		assertThat(myProject.getCollectedSum(), is(0));
		assertThat(myProject.getCategoryID(), is(0));
		assertThat(myProject.getUniqueID(), is(0));
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
		assertThat(project.getFullDescription(), is (fullDescription));
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
		assertThat(project.getCollectedSum(), is(collectedSum));
	}

	@Test
	public void testSetCollectedSum() {
		int money = 100;
		project.setCollectedSum(money);
		assertThat(project.getCollectedSum(), is(money));
	}

	@Test
	public void testGetVideoLink() {
		assertThat(project.getVideoLink(), is(videoLink));
	}

	@Test
	public void testSetVideoLink() {
		String newVideoLink = "rutube.com";
		project.setVideoLink(newVideoLink);
		assertThat(project.getVideoLink(), is(newVideoLink));
	}

	@Test
	public void testGetCategoryID() {
		assertThat(project.getCategoryID(), is(categoryID));
	}

	@Test
	public void testSetCategoryID() {
		int newCategoryID = 2;
		project.setCategoryID(newCategoryID);
		assertThat(project.getCategoryID(), is(newCategoryID));
	}

	@Test
	public void testGetUniqueID() {
		assertThat(project.getUniqueID(), is(uniqueID));
	}

	@Test
	public void testSetUniqueID() {
		int newUniqueID = 3;
		project.setUniqueID(newUniqueID);
		assertThat(project.getUniqueID(), is(newUniqueID));
	}
}
