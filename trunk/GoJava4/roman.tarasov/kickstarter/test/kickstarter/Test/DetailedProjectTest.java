package kickstarter.Test;

import static org.junit.Assert.*;
import kickstarter.entities.Category;
import kickstarter.entities.ProjectComments;
import kickstarter.entities.Project;
import kickstarter.pages.DetailedProject;
import kickstarter.repository.EntityStorage;
import kickstarter.repository.Storage;
import kickstarter.ui.UserInterface;

import org.junit.Test;

public class DetailedProjectTest {
/*	
	UserInterface ui = new ExitUI();
	Category category = new Category("category");
	Project project = new Project("project", category);

	QuestionsAndAnswers comments = new QuestionsAndAnswers(project);
	Storage<QuestionsAndAnswers> allComments = new EntityStorage<QuestionsAndAnswers>();
	Storage<Project> projects = new EntityStorage<Project>();
	DetailedProject page = new DetailedProject(ui, allComments, projects);

	@Test
	public void testSelectCommentsToProject() {
		// when
		comments.addComment(1, "one");
		comments.addComment(2, "two");
		allComments.add(comments);

		// then
		QuestionsAndAnswers commentsFromSelectedProject = page
				.selectCommentsToProject(project);
		assertEquals("one", commentsFromSelectedProject.comment[0]);
		assertEquals("two", commentsFromSelectedProject.comment[1]);
	}

	@Test
	public void test_null_project_to_SelectCommentsToProject() {

		QuestionsAndAnswers commentsFromSelectedProject = page
				.selectCommentsToProject(null);
		assertNull(commentsFromSelectedProject);
	}

*/

}
