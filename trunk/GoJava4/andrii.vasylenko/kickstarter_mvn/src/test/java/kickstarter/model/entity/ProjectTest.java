package kickstarter.model.entity;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class ProjectTest {
	@Test
	public void shouldGetTheSameProject_whenNewProject() {
		ArrayList<String> questionsAndAnswers = new ArrayList<String>();
		questionsAndAnswers.add("test question1");
		questionsAndAnswers.add("test question2");
		Project project = new Project(6, 1, "test name", "test description", 111, 11, "test history", "test link",
				questionsAndAnswers, 22);
		assertEquals(6, project.getId());
		assertEquals(1, project.getCategoryId());
		assertEquals("test name", project.getName());
		assertEquals("test description", project.getDescription());
		assertEquals(111, project.getTotalAmount());
		assertEquals(11, project.getDaysLeft());
		assertEquals("test history", project.getHistory());
		assertEquals("test link", project.getLink());
		assertEquals(questionsAndAnswers, project.getQuestionsAndAnswers());
		assertEquals(22, project.getCollectAmount());
	}
}
