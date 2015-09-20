package kickstarter.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {


	@Test
	public void shouldNextId_whenCreateNew() {
		int firstId = new Project("name", "description", 1, 1).getId();
		
		for (int i = ++firstId; i < 10 + firstId; i++) {
			Project project = new Project("Name"+i, "description"+i,  i, i);
			assertEquals(i, project.getId());
			Data data = project;
			assertEquals(i, data.getId());
		}
	}
	
	@Test
	public void shouldInitAllFields_whenCreateNeProject() {
		Project project = new Project("name", "description",  1000, 100);
		assertEquals("name", project.getName());
		assertEquals("description", project.getDescription());
		//assertEquals(category, project.getCategory());
		assertEquals(1000, project.getTotalAmount());
		assertEquals(100, project.getDaysLeft());
		assertEquals(0, project.getCollectAmount());
		assertEquals("", project.getHistory());
		assertEquals("", project.getLink());
		assertEquals("", project.getQuestionsAndAnswers());
	}
	
	@Test
	public void shouldStringHistory_whenStringHistory() {
		Project project = new Project("name", "description",  1000, 100);
		project.setHistory("History");
		assertEquals("History", project.getHistory());
		project.setHistory("NewHistory");
		assertEquals("NewHistory", project.getHistory());
	}
	
	@Test
	public void shouldStringLink_whenStringLink() {
		Project project = new Project("name", "description",  1000, 100);
		project.setLink("Link");
		assertEquals("Link", project.getLink());
		project.setLink("NewLink");
		assertEquals("NewLink", project.getLink());
	}
	
	@Test
	public void shouldStringQuestionsAndAnswers_whenStringQuestionsAndAnswers() {
		Project project = new Project("name", "description",  1000, 100);
		project.setQuestionsAndAnswers("QuestionsAndAnswers");
		assertEquals("QuestionsAndAnswers", project.getQuestionsAndAnswers());
		project.setQuestionsAndAnswers("NewQuestionsAndAnswers");
		assertEquals("NewQuestionsAndAnswers", project.getQuestionsAndAnswers());
	}
	
	@Test
	public void shouldAddCollectAmount_whenDonate() {
		Project project = new Project("name", "description",  1000, 100);
		assertEquals(0, project.getCollectAmount());
		project.donate(100);
		assertEquals(100, project.getCollectAmount());
		project.donate(200);
		assertEquals(300, project.getCollectAmount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullName() throws IllegalArgumentException {
		new Project(null, "description",  1000, 100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullDescription() throws IllegalArgumentException {
		new Project("name", null,  1000, 100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullCategory() throws IllegalArgumentException {
		new Project("name", "description",  1000, 100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenZeroTotalAmount() throws IllegalArgumentException {
		new Project("name", "description",  0, 100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenLessZeroTotalAmount() throws IllegalArgumentException {
		new Project("name", "description",  -1000, 100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenZeroDaysLeft() throws IllegalArgumentException {
		new Project("name", "description",  1000, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenLessZeroDaysLeft() throws IllegalArgumentException {
		new Project("name", "description",  1000, -100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenZeroDonation() throws IllegalArgumentException {
		Project project = new Project("name", "description",  1000, 100);
		project.donate(0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenLessZeroDonation() throws IllegalArgumentException {
		Project project = new Project("name", "description",  1000, 100);
		project.donate(-100);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullHistory() throws IllegalArgumentException {
		Project project = new Project("name", "description",  1000, 100);
		project.setHistory(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullLink() throws IllegalArgumentException {
		Project project = new Project("name", "description",  1000, 100);
		project.setLink(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldException_whenNullQuestionsAndAnswers() throws IllegalArgumentException {
		Project project = new Project("name", "description",  1000, 100);
		project.setQuestionsAndAnswers(null);
	}
	
}
