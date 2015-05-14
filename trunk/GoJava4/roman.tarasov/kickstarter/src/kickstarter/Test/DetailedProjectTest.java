package kickstarter.Test;

import static org.junit.Assert.*;

import kickstarter.UserInterface;
import kickstarter.Entities.Category;
import kickstarter.Entities.Comments;
import kickstarter.Entities.Project;
import kickstarter.Repository.EntityStorage;
import kickstarter.Repository.Storage;
import kickstarter.UserPages.DetailedProject;

import org.junit.Test;

public class DetailedProjectTest {
	UserInterface ui = new ExitUI();
	Category category = new Category("category");
	Project project = new Project("project", category);

	Comments comments = new Comments(project);
	Storage<Comments> allComments = new EntityStorage<Comments>();
	DetailedProject page = new DetailedProject(ui, allComments);

	@Test
	public void testSelectCommentsToProject() {
		// when
		comments.addComment(1, "one");
		comments.addComment(2, "two");
		allComments.add(comments);

		// then
		Comments commentsFromSelectedProject = page
				.selectCommentsToProject(project);
		assertEquals("one", commentsFromSelectedProject.comment[0]);
		assertEquals("two", commentsFromSelectedProject.comment[1]);
	}

	@Test
	public void test_null_project_to_SelectCommentsToProject() {

		Comments commentsFromSelectedProject = page
				.selectCommentsToProject(null);
		assertNull(commentsFromSelectedProject);
	}

	@Test
	public void test_detailed_project_info() {
		page.getDetailedInfo(project, allComments);
	}

}
